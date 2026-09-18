package it.esempio.ordini;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrdineServiceTest {

    private final OrdineService service = new OrdineService();

    private static Ordine ordineConDueRighe() {
        return new Ordine("ORD-1", "Rossi", List.of(
                new RigaOrdine("A1", 2, new BigDecimal("10.00")),
                new RigaOrdine("B2", 1, new BigDecimal("5.50"))));
    }

    @Test
    void totale_ordineConDueRighe_sommaGliImporti() {
        assertEquals(new BigDecimal("25.50"), service.totale(ordineConDueRighe()));
    }

    @Test
    void pezzi_ordineConDueRighe_sommaLeQuantita() {
        assertEquals(3, service.pezzi(ordineConDueRighe()));
    }

    @Test
    void totaleScontato_scontoDelDieciPerCento_toglieUnDecimo() {
        assertEquals(new BigDecimal("22.95"), service.totaleScontato(ordineConDueRighe(), 10));
    }

    @Test
    void totaleScontato_scontoZero_restituisceIlTotale() {
        assertEquals(new BigDecimal("25.50"), service.totaleScontato(ordineConDueRighe(), 0));
    }

    @Test
    void totaleScontato_percentualeOltreCento_lanciaEccezione() {
        assertThrows(IllegalArgumentException.class,
                () -> service.totaleScontato(ordineConDueRighe(), 101));
    }
}
