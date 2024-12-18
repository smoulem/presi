import groovy.json.JsonSlurper
import groovy.sql.DataSet
import groovy.sql.Sql
import org.junit.jupiter.api.Test

import java.sql.Blob

class OracleDb
{
    static String dbUrl = "jdbc:oracle:thin:@bm-smoulem:3521:CHFDB01"
    static String ibmUser = "IBM"
    static String ibmPassword = "IBM"
    static String wUser = "WANDSW"
    static String wPassword = "WANDSW"

    static JsonSlurper slurper = new JsonSlurper()

    @Test
    void "get document from database"()
    {
        String queryString = "select * from spool_file_content where client_ref = 'IBM' order by DATE_UPDATED desc"
        String outputFileName = "test.pdf"
        File outputFile = new File(outputFileName)

        Sql.withInstance(dbUrl, ibmUser, ibmPassword) {sql ->
            outputFile.withOutputStream {out ->
                def blob = sql.firstRow(queryString).get("CONTENT")
                    out << ((Blob) blob).binaryStream
            }
        }
    }

    @Test
    void "test dataset"()
    {
        Sql sql = Sql.withInstance(dbUrl, ibmUser, ibmPassword) { sql ->
            DataSet dataSet = sql.dataSet(SpoolFileContent)
            def row = dataSet.findAll { it.clientRef == ibmUser }.firstRow()
            println(row)
        }
    }

    static class SpoolFileContent {
        String clientRef
        Blob content
    }

    @Test
    void "get timings recorded in benchmarking app"()
    {
        String inputFileName = /C:\Users\smoulem\Documents\testfolder\New folder\sprint_review_all.log/
        inputFileName = /C:\Users\smoulem\Documents\testfolder\New folder\two_passed_two_failed.log/
        inputFileName = /C:\Users\smoulem\Documents\testfolder\New folder\four_passed.log/

        File inputFile = new File(inputFileName)
        String baseUrl = "https://benchmarking.services.aquilaheywood.co.uk/testCases/"
        List<String> list = (inputFile.text =~ /$baseUrl(\d+)/).findAll()*.last()

        List<String> urls = list.collect { "${baseUrl}${it}/results"}

        List res = urls.collect {getSequenceAndTimes(it)}

        println("#########")
        res.each {println(it)}
    }

    static Map getSequenceAndTimes(String url)
    {
        def parsed = slurper.parse(url.toURL())

        String seqNo = parsed._embedded.testResults.first().seqNo.toString()
        println "seqNo: $seqNo"

        List<Double> times = parsed._embedded.testResults*.elapsedTime*.toString()
                .collect { Double.parseDouble it }
        println "times: $times"

        DoubleSummaryStatistics stats = times.inject(new DoubleSummaryStatistics()) {acc, i -> acc.accept(i); acc}

        [seqNo: seqNo, stats: stats]
    }
}
