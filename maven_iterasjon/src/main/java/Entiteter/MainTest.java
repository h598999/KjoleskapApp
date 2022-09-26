package Entiteter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public class MainTest {
	
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
	
	
	
	Product product = new Product();
	Gson gson = new Gson();
	HttpRequest getRequest = HttpRequest.newBuilder()
		.uri(new URI("https://www.foodrepo.org/api/v3/products/"+"2030"))
		.header("Authorization","Token token=536f731144fa1ba705ebe3338271ba5f")
		.build();
	HttpClient httpClient = HttpClient.newHttpClient();
	HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
	JsonElement images = gson.fromJson(getResponse.body(), JsonObject.class).get("data");
	
	product = gson.fromJson(images, Product.class);

	
	System.out.println(product.getDisplayNameTranslation().toString());


	

}
}
