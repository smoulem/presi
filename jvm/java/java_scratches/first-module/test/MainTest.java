import static java.lang.Math.*;
import static java.lang.Math.min;
import static java.util.stream.IntStream.range;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class MainTest
{
    
    public static final String NO_PARALLEL = "no parallel";
    
    @Test
    void name()
    {
        int[] numbers = {8, 5, 87, 3, 2};
        
        var res = minScan( numbers );
        
        System.out.println(Arrays.toString( numbers ));
        System.out.println( Arrays.toString(res));
    }
    
    @Test
    void testScanLest()
    {
        int[] numbers = {8, 5, 87, 3, 2};
        
        var res = scanLeft( numbers, Math::min );
        
        System.out.println(Arrays.toString( numbers ));
        System.out.println( Arrays.toString(res));
    }
    
    @Test
    void findValue()
    {
//        int[] numbers = {8, 5, 87, 3, 2};
//        int[] numbers = {2, 3, 5, 8, 87};
        int[] numbers = {6, 5, 5, 4, 4};
        
        if ( ! isAscending( numbers ) ) {
            System.out.println(Arrays.toString( numbers ) + " is not ascending");
        }
        
        var mins = scanLeft( numbers, Math::min );
        
        var res = range( 0, min( numbers.length, mins.length ) )
                .map( i -> numbers[i] - mins[i] )
                .filter( i -> i != 0 )
                .max().orElse( -1 );
        
        System.out.println( Arrays.toString( numbers ) );
        System.out.println(Arrays.toString( mins ));
        System.out.println(res);
    }
    
    private boolean isAscending( int[] numbers )
    {
        var copy = Arrays.copyOf( numbers, numbers.length );
        Arrays.sort( copy );
        
        return Arrays.equals( numbers, copy );
    }
    
    int[] minScan(int[] numbers) {
        return range( 0, numbers.length )
                .collect( () -> new int[numbers.length],
                        (acc, i) -> addMin(acc, i, numbers),
                        (a, b) -> new UnsupportedOperationException(NO_PARALLEL)
                );
    }
    
    int[] scanLeft( int[] numbers, IntBinaryOperator operator )
    {
        return range( 0, numbers.length )
                .collect( () -> new int[numbers.length],
                        (acc, i) -> doMagic(acc, i, numbers, operator),
                        (a, b) -> new UnsupportedOperationException( NO_PARALLEL )
                );
    }
    
    private int[] doMagic( int[] acc, int i, int[] numbers, IntBinaryOperator operator )
    {
        if ( i == 0 )
        {
            acc[i] = numbers[i];
        } else
        {
            acc[i] = operator.applyAsInt(acc[i-1], numbers[i] );
        }
        return acc;
    }
    
    private int[] addMin( int[] acc, int i, int[] numbers )
    {
        if ( i == 0 ) {
            acc[i] = numbers[i];
        } else {
            acc[i] = min( acc[i-1], numbers[i] );
        }
        return acc;
    }
}