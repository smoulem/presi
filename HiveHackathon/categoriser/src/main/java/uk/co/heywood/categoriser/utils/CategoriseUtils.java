package uk.co.heywood.categoriser.utils;

import static java.util.stream.Collectors.groupingBy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

import lombok.SneakyThrows;

import uk.co.heywood.categoriser.model.CategorisedPath;
import uk.co.heywood.categoriser.model.Category;

public final class CategoriseUtils
{
    private CategoriseUtils()
    {
    }
    
    @SneakyThrows
    public static Map<Category, List<CategorisedPath>> execute(
            List<Category> categories,
            String rootDir,
            Predicate<Path> predicate,
            BiFunction<Path, List<Category>, CategorisedPath> function )
    {
        Objects.requireNonNull( rootDir );
        
        try ( Stream<Path> paths = Files.walk( Paths.get( rootDir ) ) )
        {
            return paths
                    .filter( predicate )
                    .map(path ->  function.apply( path, categories ) )
                    .collect( groupingBy( CategorisedPath::category ) )
                    ;
        }
    }
}
