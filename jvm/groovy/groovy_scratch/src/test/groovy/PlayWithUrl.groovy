import org.junit.jupiter.api.Test

class PlayWithUrl {
    @Test
    void "see what I can do with URL"() {
        String baseUrl = "https://google.com"
        URL url = baseUrl.toURL()
        URLConnection connection = url.openConnection()
        connection.getInputStream()
    }
}
