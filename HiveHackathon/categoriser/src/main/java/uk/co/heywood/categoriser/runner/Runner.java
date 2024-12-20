package uk.co.heywood.categoriser.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import uk.co.heywood.categoriser.model.CategorisedPath;
import uk.co.heywood.categoriser.model.Category;

@Component
public class Runner implements CommandLineRunner
{
    private final BiFunction<List<Category>, String, Map<Category, List<CategorisedPath>>> defaultProvider;
    
    public Runner( BiFunction<List<Category>, String, Map<Category, List<CategorisedPath>>> defaultProvider )
    {
        this.defaultProvider = defaultProvider;
    }
    
    @Override
    public void run( String... args ) throws Exception
    {
        List<Category> categories = Arrays.asList(
                Category.ADDRESS_CHANGE, Category.NAME_CHANGE, Category.NEW_MEMBER, Category.DEATH,
                Category.BENEFICIARY_UPDATE, Category.RETIREMENT, Category.WITHDRAWAL_REQUEST,
                Category.CONTRIBUTION_UPDATE, Category.PENSION_STATEMENT_REQUEST, Category.DISABILITY_CLAIM,
                Category.INCOME_CHANGE, Category.MARITAL_STATUS_CHANGE, Category.EMPLOYMENT_STATUS_CHANGE,
                Category.CONTACT_INFORMATION_UPDATE
        );
        
        String rootDir = Objects.isNull( args ) || args.length == 0 ? "." : args[0];
        
        defaultProvider.apply( categories, rootDir );
    }
}
