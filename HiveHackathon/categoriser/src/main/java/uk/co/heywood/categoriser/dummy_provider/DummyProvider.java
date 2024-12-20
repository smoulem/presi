package uk.co.heywood.categoriser.dummy_provider;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import uk.co.heywood.categoriser.model.Category;
import uk.co.heywood.categoriser.model.CategorisedPath;
import uk.co.heywood.categoriser.utils.CategoriseUtils;

@Component
@RequiredArgsConstructor
public class DummyProvider implements BiFunction<List<Category>, String, Map<Category, List<CategorisedPath>>>
{
    private final Predicate<Path> predicate;
    private final BiFunction<Path, List<Category>, CategorisedPath> function = DummyProvider::categorise;
    
    @Override
    public Map<Category, List<CategorisedPath>> apply( List<Category> categories, String rootDir )
    {
        return CategoriseUtils.execute(
                categories,
                rootDir,
                predicate,
                function
        );
    }
    
    private static CategorisedPath categorise( Path path, List<Category> categories )
    {
        return new CategorisedPath( path, categories.get(0), 0d ) ;
    }
}
