package uk.co.heywood.categoriser.default_provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static uk.co.heywood.categoriser.model.Category.ADDRESS_CHANGE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import uk.co.heywood.categoriser.model.CategorisedPath;
import uk.co.heywood.categoriser.model.Category;
@SpringBootTest
class DefaultProviderTests
{
    @Autowired
    BiFunction<List<Category>, String, Map<Category, List<CategorisedPath>>> defaultProvider;
    
    @TempDir
    Path tempDir;
    
    @Test
    void whenCategoriseCalled_ThenReturnCategory() throws IOException
    {
        Path tempFile = tempDir.resolve( Path.of( "test.eml" ) );
        Files.writeString( tempFile, "message in category test" );

        Map<Category, List<CategorisedPath>> result =
                defaultProvider.apply( Arrays.asList( Category.values() ), tempDir.toString() );

        assertEquals(
                Map.of( ADDRESS_CHANGE, List.of(new CategorisedPath(tempFile, ADDRESS_CHANGE, 0d ))),
                result
        );
    }
}
