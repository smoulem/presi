import org.junit.jupiter.api.Test

import java.nio.file.Files
import java.nio.file.Path

class TrimFile {
    @Test
    void "trim git alias"() {
        URL url = ClassLoader.getSystemResource("git_aliases")
        Path path = Path.of(url.toURI())

        List<String> trimmed = Files.readAllLines(path).collect {it.trim()}

        Path outputPath = path.parent.resolve("trimmed_alias")
        Files.write(outputPath, trimmed)
    }
}
