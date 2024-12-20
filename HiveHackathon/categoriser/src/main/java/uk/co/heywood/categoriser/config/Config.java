package uk.co.heywood.categoriser.config;

import java.net.http.HttpClient;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Config
{
    @Bean
    public ObjectMapper objectMapper()
    {
        return new ObjectMapper();
    }
    
    @Bean
    public HttpClient httpClient()
    {
        return HttpClient.newHttpClient();
    }
    
    @Bean
    Predicate<Path> emlPredicate()
    {
        return path -> Files.isRegularFile(path) && path.endsWith( ".eml" );
    }
}
