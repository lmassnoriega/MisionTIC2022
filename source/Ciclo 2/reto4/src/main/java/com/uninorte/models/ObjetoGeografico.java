package com.uninorte.models;

/**
 * ObjetoGeografico
 * @author Spartan Locke
 * @version 1.0 08/03/2021
 */
public class ObjetoGeografico {

    private String municipio;

    /**
     * 
     * @param municipio
     */
    public ObjetoGeografico(String municipio) {
        this.municipio = municipio;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

}