package com.aluracursos.conversor.principal;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {

    Divisas busquedaDivisa(String codigoDivisa)  {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d284ed579e881e23c8e0a5e3/latest/" + codigoDivisa);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            DivisasResponse divisasResponse = gson.fromJson(response.body(), DivisasResponse.class);
            if (divisasResponse != null && divisasResponse.getRates() != null) {
                return new Divisas(
                        divisasResponse.getBaseCode(),
                        divisasResponse.getRates().getARS(),
                        divisasResponse.getRates().getBRL(),
                        divisasResponse.getRates().getCOP()
                );
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

class DivisasResponse {
    @SerializedName("base_code")
    private String baseCode;

    @SerializedName("conversion_rates")
    private ConversionRates rates;

    public String getBaseCode() {
        return baseCode;
    }

    public ConversionRates getRates() {
        return rates;
    }
}

class ConversionRates {
    private float ARS;
    private float BRL;
    private float COP;

    public float getARS() {
        return ARS;
    }

    public float getBRL() {
        return BRL;
    }

    public float getCOP() {
        return COP;
    }
}
