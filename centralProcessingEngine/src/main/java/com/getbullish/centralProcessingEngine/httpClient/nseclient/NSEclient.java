package com.getbullish.centralProcessingEngine.httpClient.nseclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.springframework.stereotype.Service;
import okhttp3.OkHttpClient;

@Service
public class NSEclient {



  OkHttpClient client;



  public HttpResponse<String> getNifty200() throws InterruptedException, IOException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.nseindia.com/api/equity-stockIndices?index=NIFTY%2050"))
        .build();

    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

    System.out.println(response.body());
    return response;

  }
}
