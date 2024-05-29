import java.net.URI;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TasaDeCambioConsulta {

    public TasaDeCambio obtenTasaDeCambio(String monedaAConvertir) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ac52364cbac86be38c284fa5/latest/" + monedaAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            // Parsear la respuesta JSON
            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            // Crear una instancia de Conversor a partir de los datos JSON
            double ARS = conversionRates.get("ARS").getAsDouble();
            double USD = conversionRates.get("USD").getAsDouble();
            double COP = conversionRates.get("COP").getAsDouble();
            double BRL = conversionRates.get("BRL").getAsDouble();

            return new TasaDeCambio(ARS, USD, COP, BRL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Ocurrió un error inesperado.");
        }
    }
}



