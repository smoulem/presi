import org.junit.jupiter.api.Test

class Misc
{
    @Test
    void "try to automatically cast regex groups"()
    {
        def (String _, String n, String age) = ("awa 32" =~ /^(\w+) (\d+)$/)[0]
        println n
        println age
        println _
    }

    @Test
    void "play with maps"()
    {
        String aKey = "zero"
        Map aMap = [(aKey): "a value"]
        println aMap
    }
}
