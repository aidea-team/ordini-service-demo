package it.esempio.ordini;

import java.util.List;

/** Un ordine di un cliente, con le sue righe. */
public record Ordine(String numero, String cliente, List<RigaOrdine> righe) {
}
