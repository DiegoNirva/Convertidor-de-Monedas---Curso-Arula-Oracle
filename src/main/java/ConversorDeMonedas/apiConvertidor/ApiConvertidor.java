package ConversorDeMonedas.apiConvertidor;

import ConversorDeMonedas.model.DatosConsulta;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConvertidor {


    //metodo para obtener datos de api
    public DatosConsulta GetDatos(String moneda){

        URI url = URI.create("https://v6.exchangerate-api.com/v6/4b417e1a20114acc29009e16/latest/"+moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException  | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(String.valueOf(response.body()), DatosConsulta.class);
    }
}
