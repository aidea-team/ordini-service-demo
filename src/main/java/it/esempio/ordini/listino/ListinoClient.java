package it.esempio.ordini.listino;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/** Legge i prezzi dal servizio del listino. */
public class ListinoClient {

    private final HttpClient http = HttpClient.newHttpClient();
    private final URI base;

    public ListinoClient(String baseUrl) {
        this.base = URI.create(baseUrl.endsWith("/") ? baseUrl : baseUrl + "/");
    }

    /** Il prezzo unitario di un prodotto. */
    public BigDecimal prezzo(String codiceProdotto) throws IOException, InterruptedException {
        HttpRequest richiesta = HttpRequest.newBuilder(base.resolve("prezzi/" + codiceProdotto)).GET().build();
        HttpResponse<String> risposta = http.send(richiesta, HttpResponse.BodyHandlers.ofString());
        if (risposta.statusCode() != 200) {
            throw new IOException("listino: stato " + risposta.statusCode() + " per " + codiceProdotto);
        }
        return new BigDecimal(risposta.body().trim());
    }
}
