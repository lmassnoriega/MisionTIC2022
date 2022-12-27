package com.uninorte.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ObjetoGeograficoTest {

    @Test
    public void testGetMunicipio() {
        ObjetoGeografico geog = new ObjetoGeografico("Test Province");
        assertEquals("Test Province", geog.getMunicipio());
    }

    @Test
    public void testSetMunicipio() {
        ObjetoGeografico geog = new ObjetoGeografico("Test Province");
        geog.setMunicipio("Other Province");
        assertEquals("Other Province", geog.getMunicipio());
    }
}
