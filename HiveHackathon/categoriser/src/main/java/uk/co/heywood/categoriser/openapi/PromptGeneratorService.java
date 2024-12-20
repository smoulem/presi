package uk.co.heywood.categoriser.openapi;

import static java.util.stream.Collectors.joining;

import java.util.List;

import org.springframework.stereotype.Service;

import uk.co.heywood.categoriser.model.Category;

@Service
public class PromptGeneratorService
{
    public String generatePrompt( String content, List<Category> categories )
    {
        var categoriesName = categories.stream().map( Enum::name ).collect( joining( ", " ) );
        
        return """
                Please categorise the following content into one of the following categories and provide a confidence score as a \
                percentage. If you don't think it fits any, send back 'Fail'. Format the response as \
                'Category: <category>, Confidence: <confidence>%%'
                Categories: %s
                Content: %s
                """.formatted( categoriesName, content );
    }
}
