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

import Entiteter.Vare;
import HjelpeKlasser.NameTranslations;
import HjelpeKlasser.displayNameTranslation;
import HjelpeKlasser.image;

public class VareGetter {

	public static Vare getVare(int id) throws URISyntaxException, IOException, InterruptedException {
		Transcript transcript = new Transcript();
		image bilde = new image();
		Gson gson = new Gson();
		HttpRequest getRequest = HttpRequest.newBuilder()
			.uri(new URI("https://www.foodrepo.org/api/v3/products/"+id))
			.header("Authorization","Token token=536f731144fa1ba705ebe3338271ba5f")
			.build();
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
		JsonElement convertedObject = gson.fromJson(getResponse.body(), JsonObject.class).get("data");
		JsonElement name_translations = gson.fromJson(getResponse.body(), JsonObject.class).get("name_translations");
		JsonElement display_name_translations = gson.fromJson(getResponse.body(), JsonObject.class).get("display_name_translations");
		JsonElement images = gson.fromJson(getResponse.body(), JsonObject.class).get("images");
		bilde = gson.fromJson(images, image.class);
		displayNameTranslation displayTranslations = gson.fromJson(display_name_translations, displayNameTranslation.class);
		NameTranslations translations = gson.fromJson(name_translations, NameTranslations.class);
		System.out.println(bilde.toString());
		System.out.println(translations.toString());
		System.out.println(displayTranslations);
		transcript = gson.fromJson(convertedObject, Transcript.class);
		System.out.println(getResponse.body());
		return new Vare(transcript.getId(),transcript.getBarcode());
		
	}
	
}
