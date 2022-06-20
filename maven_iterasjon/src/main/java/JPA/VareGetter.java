package JPA;

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

import Entiteter.Vare;

public class VareGetter {

	public static Vare getVare(int id) throws URISyntaxException, IOException, InterruptedException {
		Transcript transcript = new Transcript();
		Gson gson = new Gson();
		HttpRequest getRequest = HttpRequest.newBuilder()
			.uri(new URI("https://www.foodrepo.org/api/v3/products/"+id))
			.header("Authorization","Token token=536f731144fa1ba705ebe3338271ba5f")
			.build();
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
		JsonElement convertedObject = gson.fromJson(getResponse.body(), JsonObject.class).get("data");
		transcript = gson.fromJson(convertedObject, Transcript.class);
		return new Vare(transcript.getId(),transcript.getBarcode());
		
	}
	
}
