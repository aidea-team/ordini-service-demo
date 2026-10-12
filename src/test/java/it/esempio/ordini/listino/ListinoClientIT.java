package it.esempio.ordini.listino;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ListinoClientIT {

    @Test
    void prezzo_prodottoEsistente_restituisceUnImportoPositivo() throws Exception {
        String url = System.getenv("LISTINO_URL");
        assumeTrue(url != null && !url.isBlank(), "LISTINO_URL non impostata");

        BigDecimal prezzo = new ListinoClient(url).prezzo("A1");

        assertTrue(prezzo.signum() > 0);
    }
}
