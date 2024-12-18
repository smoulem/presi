import groovy.transform.Canonical
import org.junit.jupiter.api.Test

import java.nio.file.Files
import java.nio.file.Path

class AnalyseLogFiles
{

    static final String DONE_IN_PATTERN = /\[done in (\d+)ms\]/

    static final String GENERAL_PATTERN = /(\w+)\s+\|\s+(.+)\s+\|\s+(.*)\s+\|\s+(.*)/

    @Test
    void 'get lines have a duration'() {
        String dirname = /C:\Users\smoulem\Documents\testfolder\\prb008847\xps logs/
        String inputFileName = "altairmain-wrapper.log.5"

        Path inputPath  = Path.of(dirname, inputFileName)

        List<String> linesWithTime = Files.readAllLines(inputPath).findAll {it =~ DONE_IN_PATTERN }
        int maxDuration = 500
        List<String> longJobs = linesWithTime.findAll {durationMoreThan(it, maxDuration) }

        String outputFileName = "output.log"
        Path outputPath = Path.of(dirname, outputFileName)
        Files.deleteIfExists(outputPath)

        Files.write(outputPath, longJobs)

        println longJobs
    }

    @Test
    void "parse lines in log file"() {
        String dirname = /C:\Users\smoulem\Documents\testfolder\\prb008847\xps logs/
        String inputFileName = "altairmain-wrapper.log.5"

        Path inputPath  = Path.of(dirname, inputFileName)

        List<String> parsedLines = Files.readAllLines(inputPath)

        List logRecords = ( 0..<parsedLines.size() )
                .collect {lineNo -> parse( inputPath, lineNo + 1, parsedLines.get(lineNo) ) }
                .findAll { it.isPresent() }*.get()

        println logRecords?[0]
    }

    @Test
    void "parse given patterns and print out"() {
        String dirname = /C:\Users\smoulem\Documents\testfolder\\prb008847\xps logs/
        String inputFileName = "altairmain-wrapper.log.5"

        Path inputPath  = Path.of(dirname, inputFileName)
        String pattern = /15:25.*PS5280BatchJob/

        String outputFileName = "extracts_at_15_25.log"
        Path outputPath = Path.of(dirname, outputFileName)

        List res = parsePattern(inputPath, pattern)
        safeWrite(outputPath, res)
    }

    static Path safeWrite(Path path, Iterable<? extends CharSequence> lines) {
        Files.deleteIfExists(path)
        Files.write(path, lines)
    }

    static List<? extends CharSequence> parsePattern(Path path, String pattern) {
                Files.readAllLines(path).findAll {it =~ pattern }
    }

    static boolean durationMoreThan(String line, wantedDuration) {
        def (_, duration) = (line =~ DONE_IN_PATTERN)[0]
        duration as int >= wantedDuration
    }

    @Newify([LogRecord])
    static Optional<LogRecord> parse( Path path, int lineNo, String line) {
        if ( !(line ==~ GENERAL_PATTERN) )
        {
            Optional.empty()
        }
        else
        {
            def (_, logLevel, threadName, date, message) = ( line =~ GENERAL_PATTERN )[0]
            List args = [logLevel, threadName, date, message].collect { it as String }.collect { it.trim() }
            Optional.of( LogRecord( path, lineNo, *args ) )
        }
    }
}

@Canonical
class LogRecord
{
    Path path
    int lineNo
    String logLevel, threadName, date, message
}
