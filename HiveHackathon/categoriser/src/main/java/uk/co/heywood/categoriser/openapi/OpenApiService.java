package uk.co.heywood.categoriser.openapi;

import static uk.co.heywood.categoriser.openapi.OpenAiUtils.API_KEY;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.SneakyThrows;

@Service
public class OpenApiService
{
    private final HttpClient httpClient;
    
    private final ObjectMapper objectMapper;
    
    public OpenApiService( HttpClient httpClient, ObjectMapper objectMapper )
    {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }
    
    public String sendOpenAIRequest( String prompt ) throws IOException, InterruptedException
    {
        ObjectNode requestBody = objectMapper.createObjectNode();
        ArrayNode messagesArray = objectMapper.createArrayNode();
        
        ObjectNode messageNode = objectMapper.createObjectNode();
        messageNode.put( "role", "user" );
        messageNode.put( "content", prompt );
        
        messagesArray.add( messageNode );
        
        requestBody.put( "model", "gpt-3.5-turbo" );
        requestBody.set( "messages", messagesArray );
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri( URI.create( "https://api.openai.com/v1/chat/completions" ) )
                .header( "Content-Type", "application/json" )
                .header( "Authorization", "Bearer " + API_KEY )
                .POST( HttpRequest.BodyPublishers.ofString( objectMapper.writeValueAsString( requestBody ) ) )
                .build();
        
        HttpResponse<String> response = httpClient.send( request, HttpResponse.BodyHandlers.ofString() );
        
        if ( response.statusCode() == 200 )
        {
            return parseOpenAIResponse( response.body() );
        }
        
        System.err.println( "Error from OpenAI API: " + response.body() );
        return "";
    }
    
    @SneakyThrows
    private String parseOpenAIResponse( String responseBody )
    {
        JsonNode root = objectMapper.readTree( responseBody );
        JsonNode textNode = root.path( "choices" ).get( 0 ).path( "message" ).path( "content" );
        return textNode.asText().trim();
    }
}
