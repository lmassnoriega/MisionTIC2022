package com.uninorte.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.uninorte.models.CuerpoDeAgua;

/**
 * 
 */
public class reto3 {
    private ArrayList<CuerpoDeAgua> cuerpos;
    private static final String DECIMAL_FORMAT = "%.2f";

    /**
     *
     */
    public reto3() {
        this.cuerpos = new ArrayList<>();
    }

    /**
     *
     * @param lectura
     */
    public void anadirCuerpo(String lectura) {
        String[] datos = lectura.split(" ");
        CuerpoDeAgua cuerpo = new CuerpoDeAgua(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3], datos[4],
                Float.parseFloat(datos[5]));
        cuerpos.add(cuerpo);
    }

    /**
     *
     */
    public void ircaIndividual() {
        for (CuerpoDeAgua cuerpo : cuerpos) {
            System.out.println(String.format(DECIMAL_FORMAT, cuerpo.getIrca()));
        }
    }

    /**
     *
     */
    public void cuerposBajosSinRiesgo() {
        float sinriesgos = 0;
        for (CuerpoDeAgua cuerpo : cuerpos) {
            if (CuerpoDeAgua.index(cuerpo.nivel()) < 2) {
                sinriesgos++;
            }
        }
        System.out.println(String.format(DECIMAL_FORMAT, sinriesgos));
    }

    /**
     *
     */
    public void cuerposSinRiesgo() {
        StringBuilder sinriesgos = new StringBuilder();
        for (CuerpoDeAgua cuerpo : cuerpos) {
            if (CuerpoDeAgua.index(cuerpo.nivel()) == 0) {
                sinriesgos.append(cuerpo.getNombre()).append(" ");
            }
        }

        if (sinriesgos.toString().isEmpty()) {
            System.out.println("NA");
        } else {
            System.out.println(sinriesgos);
        }
    }

    /**
     *
     */
    public void ircaPromedio() {
        float suma = 0;
        for (CuerpoDeAgua cuerpoDeAgua : cuerpos) {
            suma += cuerpoDeAgua.getIrca();
        }
        System.out.println(String.format(DECIMAL_FORMAT, (suma / cuerpos.size())));
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        reto3 actividad = new reto3();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        try {
            int lecturas = Integer.parseInt(lector.readLine());
            for (int i = 0; i < lecturas; i++) {
                String data = lector.readLine();
                actividad.anadirCuerpo(data);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer los datos de entrada");
        }
        actividad.ircaIndividual();
        actividad.cuerposBajosSinRiesgo();
        actividad.cuerposSinRiesgo();
        actividad.ircaPromedio();
    }
}
