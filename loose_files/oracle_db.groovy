@GrabConfig(systemClassLoader=true)
@Grab("com.oracle.database.jdbc:ojdbc11:23.5.0.24.07")

import groovy.sql.Sql
import groovy.sql.DataSet

import java.sql.Blob

String dbUrl = "jdbc:oracle:thin:@bm-smoulem:3521:CHFDB01"
String driverClassName = "oracle.jdbc.driver.OracleDriver"

Map commons = [
    url: dbUrl,
    driverClassName: driverClassName
]
Map urls = [
    url: dbUrl
]

Map dbSettings =  [
    url: dbUrl,
    user: "IBM",
    password: "IBM"
]

Map wdbSettings = [
    url: dbUrl,
    user: "WANDSW",
    password: "WANDSW"
]

class SpoolFileContent {
    String client_ref
    Blob content
}

Sql.withInstance(wdbSettings) { sql -> 
//    String queryString = "select client_ref from spool_file_content where client_ref = 'WANDSW' order by DATE_UPDATED desc"
//    def res = sql.firstRow(queryString)
//    println res
    DataSet data = sql.dataSet("spool_file_content")
    
    def res = data.find { it.client_ref == "WANDSW" }
    println res
}
