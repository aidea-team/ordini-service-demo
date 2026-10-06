package it.esempio.ordini.listino;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ListinoClientTest {

    @Test
    void costruttore_indirizzoNonValido_lanciaEccezione() {
        assertThrows(IllegalArgumentException.class, () -> new ListinoClient("non un indirizzo"));
    }
}
