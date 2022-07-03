package JPA;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.prism.Image;

import Entiteter.Kjøleskap;
import Entiteter.Product;
import Entiteter.Vare;
import HjelpeKlasser.BarCodeSaver;
import HjelpeKlasser.NameTranslations;
import HjelpeKlasser.displayNameTranslation;
import HjelpeKlasser.image;

public class VareGetter {

	public static Product getVare(int id) throws URISyntaxException, IOException, InterruptedException {
		Product transcript = new Product();
	
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
	
	public static Product getVare(String barcode) throws URISyntaxException, IOException, InterruptedException {
		Product transcript = new Product();
		Gson gson = new Gson();
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI("https://www.foodrepo.org/api/v3/products?barcodes="+barcode))
				.header("Authorization", "Token token=536f731144fa1ba705ebe3338271ba5f")
				.build();
		HttpClient httpClient =  HttpClient.newHttpClient();
		HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
		JsonElement convertedObject = gson.fromJson(getResponse.body(), JsonObject.class).get("data");
		transcript = gson.fromJson(convertedObject.getAsJsonArray().get(0), Product.class);
		return transcript;
				
	}
	
	public static void getVarer(Kjøleskap kjøleskap, BarCodeSaver saver) {
		try {
		String getString = "https://www.foodrepo.org/api/v3/products?barcodes="+saver.getBarCodes()[0].getKey();
		Gson gson = new Gson();
		Product transcript = new Product();
		Product[] varer = new Product[saver.getAntall()];
		for (int i = 1; i<saver.getAntall(); i++) {
			getString+= "%2C"+saver.getBarCodes()[i].getKey();
		}
		System.out.println(getString);
			HttpRequest getRequest = HttpRequest.newBuilder()
					.uri(new URI(getString))
					.header("Authorization", "Token token=536f731144fa1ba705ebe3338271ba5f")
					.build();
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
			JsonElement productArray = gson.fromJson(getResponse.body(), JsonObject.class).get("data");
			
			
			for (int i = 0; i<varer.length; i++) {
				transcript = gson.fromJson(productArray.getAsJsonArray().get(i), Product.class);
				kjøleskap.leggTilFlere(transcript, saver.getBarCodes()[i].getValue());
			}
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
