package it.esempio.ordini.listino;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Tiene in memoria i prezzi letti dal listino, per non chiamarlo a ogni riga. */
public class CacheListino {

    private final ListinoClient client;
    private final Map<String, BigDecimal> prezzi = new ConcurrentHashMap<>();

    public CacheListino(ListinoClient client) {
        this.client = client;
    }

    public BigDecimal prezzo(String codiceProdotto) throws IOException, InterruptedException {
        BigDecimal prezzo = prezzi.get(codiceProdotto);
        if (prezzo == null) {
            prezzo = client.prezzo(codiceProdotto);
            prezzi.put(codiceProdotto, prezzo);
        }
        return prezzo;
    }
}
