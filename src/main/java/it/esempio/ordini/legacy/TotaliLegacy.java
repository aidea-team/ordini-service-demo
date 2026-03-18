package it.esempio.ordini.legacy;

/** Totali calcolati con double, come nel vecchio gestionale. */
public final class TotaliLegacy {

    private TotaliLegacy() {
    }

    public static double totale(double[] importi) {
        double somma = 0;
        for (double importo : importi) {
            somma += importo;
        }
        return Math.round(somma * 100.0) / 100.0;
    }
}
