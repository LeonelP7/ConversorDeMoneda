import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambio {

    //metodo para consultar la API para hacer la conversion de una moneda a otra
    public float consultaCambio(String baseCode, String targetCode, float amount){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/38607362b973d49ea030ffd1/pair/" +
                baseCode + "/" + targetCode + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Cambio cambio = new Gson().fromJson(response.body(), Cambio.class);
            return cambio.conversion_result();
        } catch (Exception e) {
            throw new RuntimeException("Ha ocurrido un error :( \n" + e);
        }
    }
}
