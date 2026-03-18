package it.esempio.ordini.export;

import static org.junit.jupiter.api.Assertions.assertEquals;

import it.esempio.ordini.Ordine;
import it.esempio.ordini.RigaOrdine;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class EsportazioneCsvTest {

    @Test
    void riga_ordineConDueRighe_scriveNumeroClientePezziTotale() {
        Ordine ordine = new Ordine("ORD-1", "Rossi", List.of(
                new RigaOrdine("A1", 2, new BigDecimal("10.00")),
                new RigaOrdine("B2", 1, new BigDecimal("5.50"))));

        assertEquals("ORD-1;Rossi;3;25.50", new EsportazioneCsv().riga(ordine));
    }
}
