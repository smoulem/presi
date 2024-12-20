package uk.co.heywood.categoriser.openapi;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.BiFunction;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import uk.co.heywood.categoriser.model.CategorisedPath;
import uk.co.heywood.categoriser.model.Category;
import uk.co.heywood.categoriser.utils.CategoryDeterminer;

@Service
@RequiredArgsConstructor
public class MessageProcessor implements BiFunction<Path, List<Category>, CategorisedPath>
{
    private final OpenApiService openApiService;
    
    private final PromptGeneratorService promptGeneratorService;
    
    private final CategoryDeterminer categoryDeterminer;
    
    @SneakyThrows
    @Override
    public CategorisedPath apply( Path path, List<Category> categories )
    {
        System.out.println( "Processing file: " + path );
        String content = Files.readString( path );
        System.out.println( "File content: " + content );  // Output the content of the file
        
        String response = openApiService.sendOpenAIRequest(
                promptGeneratorService.generatePrompt( content, categories )
        );
        
        System.out.println( "File: " + path.getFileName() );
        System.out.println( "Categorisation: " + response );
        
        String[] responseParts = response.split( "Confidence:" );
        String categorisation = responseParts[0].trim();
        String confidenceString = responseParts.length > 1 ? responseParts[1].trim().replace( "%", "" ) : "0";
        double confidence = Double.parseDouble( confidenceString );
        
        Category category = categoryDeterminer.determineCategory( categorisation, categories );
        System.out.println( "Determined Category: " + category );
        System.out.printf( "Confidence: %.1f%%%n", confidence );
        
        return new CategorisedPath( path, category, confidence );
    }
}
