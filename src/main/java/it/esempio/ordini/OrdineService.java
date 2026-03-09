package it.esempio.ordini;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Calcoli sugli ordini. */
public class OrdineService {

    /** Il totale dell'ordine: la somma degli importi delle righe, a due decimali. */
    public BigDecimal totale(Ordine ordine) {
        return ordine.righe().stream()
                .map(RigaOrdine::importo)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    /** Il numero di pezzi dell'ordine: la somma delle quantità delle righe. */
    public int pezzi(Ordine ordine) {
        return ordine.righe().stream()
                .mapToInt(RigaOrdine::quantita)
                .sum();
    }
}
