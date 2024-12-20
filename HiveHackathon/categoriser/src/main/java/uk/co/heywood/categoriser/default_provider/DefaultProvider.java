package uk.co.heywood.categoriser.default_provider;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import uk.co.heywood.categoriser.model.CategorisedPath;
import uk.co.heywood.categoriser.model.Category;
import uk.co.heywood.categoriser.utils.CategoriseUtils;
import uk.co.heywood.categoriser.openapi.MessageProcessor;

@Component
@Primary
@RequiredArgsConstructor
public class DefaultProvider implements BiFunction<List<Category>, String, Map<Category, List<CategorisedPath>>>
{
    private final Predicate<Path> predicate;
    private final MessageProcessor messageProcessor;
    
    @Override
    public Map<Category, List<CategorisedPath>> apply( List<Category> categories, String rootDir )
    {
        return CategoriseUtils.execute(
                categories,
                rootDir,
                predicate,
                messageProcessor::apply
        );
    }
}
