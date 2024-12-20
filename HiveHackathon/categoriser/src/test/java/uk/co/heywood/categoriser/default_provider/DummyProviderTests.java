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
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import uk.co.heywood.categoriser.dummy_provider.DummyProvider;
import uk.co.heywood.categoriser.model.CategorisedPath;
import uk.co.heywood.categoriser.model.Category;
import uk.co.heywood.categoriser.utils.CategoriseUtils;

@SpringBootTest
class DummyProviderTests
{
    @Autowired
    BiFunction<List<Category>, String, Map<Category, List<CategorisedPath>>> dummyProvider;
    
    @TempDir
    Path tempDir;
    
    @Test
    void whenCategoriseCalled_ThenReturnCategory() throws IOException
    {
        Path tempFile = tempDir.resolve( Path.of( "test.eml" ) );
        Files.writeString( tempFile, "message in category test" );
        
        Map<Category, List<CategorisedPath>> result =
                dummyProvider.apply( Arrays.asList( Category.values() ), tempDir.toString() );
        
        assertEquals(
                Map.of( ADDRESS_CHANGE, List.of( new CategorisedPath( tempFile, ADDRESS_CHANGE, 0d ) ) ),
                result
        );
    }
    
    @TestConfiguration
    static class TesConfig
    {
        @Bean
        Predicate<Path> emlPredicate()
        {
            return path -> Files.isRegularFile( path ) && path.endsWith( ".eml" );
        }
        
        @Bean
        BiFunction<Path, List<Category>, CategorisedPath> getFunction()
        {
            return ( path, categories ) -> new CategorisedPath( path, categories.get( 0 ), 0d );
        }
        
        @Bean
        BiFunction<List<Category>, String, Map<Category, List<CategorisedPath>>> getProvider
                (
                        Predicate<Path> predicate,
                        BiFunction<Path, List<Category>, CategorisedPath> biFunction
                )
        {
            return ( categories, rootDir ) -> CategoriseUtils.execute(
                    categories,
                    rootDir,
                    predicate,
                    biFunction
            );
        }
        
    }
}
