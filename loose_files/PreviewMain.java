import java.util.ArrayList;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class PreviewMain
{
    public static void main( String[] args )
    {
        myMinScan();
    }
    
    static void myMinScan()
    {
        var res = Stream.of( 2, -1, 0, 39 )
                .gather( Gatherer.of(
                                () -> new ArrayList<Integer>( Integer.MAX_VALUE ),
                                ( state, item, downstream ) ->
                                {
                                    var m = Math.min( state.getLast(), item );
                                    downstream.push( m );
                                    state.add( m );
                                    return true;
                                },
                                ( a, b ) -> new ArrayList<Integer>( Math.min( a.getLast(), b.getLast() ) ),
                                ( _, _ ) ->
                                {
                                }
                        )
                )
                .toList();
        
        System.out.println(res);
    }
    
    static void minScan()
    {
        var result = Stream.of( 1, 8, 20 )
                .gather(
                        Gatherers.scan(
                                ()-> Integer.MAX_VALUE,
                                Math::min
                        )
                )
                .toList()
        ;
        
        System.out.println(result);
    }
}