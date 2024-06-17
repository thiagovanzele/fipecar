package br.com.vanzele.model.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsomeApiService {
	
	private static HttpClient client = HttpClient.newHttpClient(); 
	
	public static String retornaJson(String endereco) {
		
		HttpRequest request = HttpRequest.newBuilder(URI.create(endereco)).build();
		HttpResponse<String> response = null;
		
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		return response.body();
	}

}
