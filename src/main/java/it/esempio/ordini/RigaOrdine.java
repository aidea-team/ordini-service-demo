package it.esempio.ordini;

import java.math.BigDecimal;

/** Una riga d'ordine: un prodotto, la quantità e il prezzo unitario. */
public record RigaOrdine(String codiceProdotto, int quantita, BigDecimal prezzoUnitario) {

    public BigDecimal importo() {
        return prezzoUnitario.multiply(BigDecimal.valueOf(quantita));
    }
}
