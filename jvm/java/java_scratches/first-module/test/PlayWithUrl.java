import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class PlayWithUrl
{
    @Test
    void tryThingsWithUrl() throws IOException
    {
        URL url = new URL( "https://google.com" );
        URLConnection urlConnection = url.openConnection();
        
        System.out.println(urlConnection.getLastModified());
        
        System.out.println(urlConnection.getContentType());
        System.out.println(urlConnection.getContentLength());
        System.out.println(urlConnection.getContentEncoding());
        
        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
        headerFields.forEach( (key,value) -> {
            System.out.println("%s -> %s".formatted( key, value ));
        } );
        
        BufferedReader reader = new BufferedReader( new InputStreamReader( urlConnection.getInputStream() ) );
        System.out.println(reader.lines().toList());
    }
}
