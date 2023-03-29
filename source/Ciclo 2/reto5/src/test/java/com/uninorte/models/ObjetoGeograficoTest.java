package com.uninorte.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjetoGeograficoTest {

    @Test
    void testGetMunicipio() {
        ObjetoGeografico geog = new ObjetoGeografico("Test Province");
        assertEquals("Test Province", geog.getMunicipio());
    }

    @Test
    void testSetMunicipio() {
        ObjetoGeografico geog = new ObjetoGeografico("Test Province");
        geog.setMunicipio("Other Province");
        assertEquals("Other Province", geog.getMunicipio());
    }
}