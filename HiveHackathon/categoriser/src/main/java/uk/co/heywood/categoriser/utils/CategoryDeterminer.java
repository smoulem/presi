package uk.co.heywood.categoriser.utils;

import static uk.co.heywood.categoriser.model.Category.FAIL;

import java.util.List;

import org.springframework.stereotype.Service;

import uk.co.heywood.categoriser.model.Category;

@Service
public class CategoryDeterminer
{
    public Category determineCategory( String response, List<Category> categories )
    {
        if ( response == null )
        {
            return FAIL;
        }
        
        return categories.stream()
                .filter( category -> response.contains( category.name() ) )
                .findFirst()
                .orElse( FAIL );
    }
}
