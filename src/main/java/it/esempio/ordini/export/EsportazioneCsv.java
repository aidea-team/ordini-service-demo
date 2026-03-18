package it.esempio.ordini.export;

import it.esempio.ordini.Ordine;
import it.esempio.ordini.RigaOrdine;
import it.esempio.ordini.legacy.TotaliLegacy;
import java.util.Locale;

/** Le righe del file CSV che il batch notturno legge. */
public class EsportazioneCsv {

    /** Una riga per ordine: numero;cliente;pezzi;totale. */
    public String riga(Ordine ordine) {
        double[] importi = ordine.righe().stream()
                .mapToDouble(riga -> riga.importo().doubleValue())
                .toArray();
        int pezzi = ordine.righe().stream().mapToInt(RigaOrdine::quantita).sum();
        return String.join(";",
                ordine.numero(),
                ordine.cliente(),
                String.valueOf(pezzi),
                String.format(Locale.ROOT, "%.2f", TotaliLegacy.totale(importi)));
    }
}
