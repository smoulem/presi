package net.sammy

import java.nio.file.Files
import java.nio.file.Path

fileName = "git_aliases"

boolean trimFile() {
    URL url = ClassLoader.getSystemResource("git_aliases")
    Path path = Path.of(url.toURI())

    List<String> trimmed = Files.readAllLines(path).collect { it.trim() }

    Path outputPath = path.parent.resolve("trimmed_alias")
    Files.write(outputPath, trimmed)

    true
}

boolean trimAgain() {
    File output = new File("out")

    List result = []
    new File(fileName).eachLine { line ->
        result << line.stripIndent()
    }
    output.text = result.join("\n")

    true
}

//File[] files = new File(".").listFiles()
//println(files)

println(trimAgain())