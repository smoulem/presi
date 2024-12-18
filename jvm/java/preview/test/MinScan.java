import static java.util.stream.Gatherers.scan;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class MinScan
{
    @Test
    void minScan()
    {
        var nums = new int[] {1, 8, 20};
        
        var result = Arrays.stream( nums ).boxed()
                .gather(
                        scan(
                                ()-> Integer.MAX_VALUE,
                                Math::min
                        )
                )
                .mapToInt(i->i).toArray()
                ;
        
        var r = IntStream.range( 0, Math.min( nums.length, result.length ) )
                .map( i ->  nums[i] - result[i])
                .filter( j -> j != 0 )
                .max();
        
        System.out.printf( "max diff: %d%n", r.orElse( -1 ));
    }
}
