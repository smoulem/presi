import groovy.io.FileType
import org.junit.jupiter.api.Test

import java.nio.file.Files
import java.nio.file.Path
import java.util.Map.Entry
import java.util.regex.Pattern
import java.util.stream.Stream

final class BenchMarkingOrder
{
    static final String dirName = "C:\\projects\\git\\altair-testing\\AltairBenchmarking\\src\\test\\java\\uk\\co\\heywood\\testing\\benchmarking\\batch"
    static final Path rootDir = Path.of(dirName)

    static final Pattern ORDER_PATTERN = ~/@Order\( (\d+) \)/

    @Test
    @Newify([File])
    void "scratch pad"()
    {
        List<File> files = []
        File(dirName).traverse(
                [
                        type: FileType.FILES,
                        filter: { it.name.endsWith(".java") && it.text =~ /@Order/ },
                        maxDepth: 1
                ]
        ) {files << it }

        def entries = files.collectMany { fileAndOrder(it).entrySet() }
        entries.sort {a, b -> a.value <=> b.value }
        entries.each {println(it)}
    }

    static Map<String, Integer> fileAndOrder(File file)
    {
        [(file.name): extractOrder(file)]
    }

    static int extractOrder(File file)
    {
        def (_, order) = (file.text =~ ORDER_PATTERN)[0]
        order as int
    }

    @Test
    void "test filtering files with @Order"()
    {
        try(Stream<Path> allPaths = Files.list(rootDir))
        {
            var res = allPaths.filter {hasOrder(it) }
            .sorted( Comparator.comparing( (Path path) -> getOrder(path).value ) )
            .toList()

            println(res)
        }
    }

    @Test
    void "sort by @Order"()
    {
        try(Stream<Path> allFiles = Files.list(rootDir)) {
            def res = allFiles.filter(  path -> hasOrder(path) )
            .map(BenchMarkingOrder::getOrder)
            .sorted (Comparator.comparing(( Entry<Path, Integer> e) -> e.value ) )
            .toList()

            res.forEach( System.out::println )
        }
    }

    @Test
    void "filter test with login IBM"()
    {
        final String IBM = "Logins.IBM"

        try(Stream<Path> allFiles = Files.list(rootDir)) {
            def res = allFiles.filter(  path ->
            {
                try
                {
                    Files.lines(path).anyMatch(line -> line.contains(IBM))
                } catch (ignored)
                {
                    false
                }
            }
            ).toList()

            println res
        }
    }

    static boolean hasOrder(Path path)
    {
        try(Stream<String> allLines = Files.lines(path))
        {
            allLines.any { it =~ ORDER_PATTERN }
        } catch (ignored)
        {
            false
        }
    }

    static Map.Entry<Path, Integer> getOrder(Path path) {
        try(Stream<String> lines = Files.lines(path)) {
            String string = lines.find { it =~ ORDER_PATTERN }
            def (_, order) = (string =~ ORDER_PATTERN)[0]
            Map.entry(path.fileName, order as int)
        }
    }
}
