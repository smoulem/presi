import org.junit.jupiter.api.Test

import static groovy.io.FileType.FILES

class ScriptTest {
    @Test
    void "list files in directory"() {
        rootDirName = "/Users/smoulem/Downloads/toaction/PRB"
        rootDir = new File(rootDirName)
        nameFilter = ~/altair.*/
        altairLogFiles = []

        rootDir.traverse([
                type: FILES,
                nameFilter: nameFilter
        ]) {altairLogFiles << it}

        println(altairLogFiles)
    }

    List<String> process(File file, String outputFileName) {
        output = new File(outputFileName)

        file.filterLine { it =~ /pattern/ }
                .writeTo(output.newWriter())

        file.eachLine  {
            if (it =~ /pattern/) {
                def array = it.split('|')
                """\
                    level:
                    ${array?[0].trim()} ,
                    jvm:
                    ${array?[1].trim()} ,
                    dateTime:
                    ${array[2].trim()} ,
                    memory:
                    ${toLogMessage(array?[3])}"""

            } else {
                ""
            }
            []
        }
    }

    Map toLogMessage(String message) {
        def array = message.split(' ')
        [
                used: array?[4]?.trim()?.substring(0, -2),
                free: array?[6]?.trim()?.substring(0, -2),
                total: array?[9]?.trim()?.substring(0, -2),
                max: array?[11]?.trim()?.substring(1, -2),
                javaClass: array?[13]?.trim()?.substring(1, -2),
                workerThread: array?[14]?.trim()?.substring(1, -2)
        ]
    }
}


