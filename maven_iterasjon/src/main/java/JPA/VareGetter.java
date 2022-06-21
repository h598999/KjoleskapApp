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
import com.sun.prism.Image;

import Entiteter.Product;
import Entiteter.Vare;
import HjelpeKlasser.NameTranslations;
import HjelpeKlasser.displayNameTranslation;
import HjelpeKlasser.image;

public class VareGetter {

	public static Product getVare(int id) throws URISyntaxException, IOException, InterruptedException {
		Product transcript = new Product();
		image bilde = new image();
		Gson gson = new Gson();
		HttpRequest getRequest = HttpRequest.newBuilder()
			.uri(new URI("https://www.foodrepo.org/api/v3/products/"+id))
			.header("Authorization","Token token=536f731144fa1ba705ebe3338271ba5f")
			.build();
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
		JsonElement convertedObject = gson.fromJson(getResponse.body(), JsonObject.class).get("data");
		transcript = gson.fromJson(convertedObject, Product.class);
		return transcript;
		
		
	}
	
}
