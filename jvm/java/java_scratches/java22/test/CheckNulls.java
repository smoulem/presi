import org.junit.jupiter.api.Test;

public class CheckNulls
{
    enum Colors {BLUE, RED}
    
    @Test
    void name()
    {
        if ( Colors.RED == null ) {
            System.out.println(":)");
        } else {
            System.out.println(":(");
        }
    }
}
