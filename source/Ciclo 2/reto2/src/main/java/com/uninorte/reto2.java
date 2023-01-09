package com.uninorte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Clase principal del reto 2 de programacion basica del ciclo 2.
 * 
 * @version 1.1 07/27/2021
 * @author Spartan Locke
 */
public class reto2 {
    private ArrayList<CuerpoDeAgua> cuerpos;
    public static final String DECIMAL_FORMAT = "%4.2f";

    /**
     * 
     */
    public reto2() {
        this.cuerpos = new ArrayList<>();
    }

    /**
     * 
     * @param lectura
     */
    public void anadirCuerpo(String lectura) {
        String[] datos = lectura.split(" ");
        CuerpoDeAgua cuerpo = new CuerpoDeAgua(datos[0], Integer.parseInt(datos[1]), datos[2],
                Float.parseFloat(datos[3]));
        cuerpos.add(cuerpo);
    }

    /**
     * 
     */
    public void ircaIndividual() {
        for (CuerpoDeAgua cuerpo : cuerpos) {
            System.out.println(String.format(DECIMAL_FORMAT, cuerpo.irca));
        }
    }

    /**
     * 
     */
    public void cuerposBajosSinRiesgo() {
        float sinRiesgos = 0;
        for (CuerpoDeAgua cuerpo : cuerpos) {
            if (CuerpoDeAgua.index(cuerpo.nivel()) < 2) {
                sinRiesgos++;
            }
        }
        System.out.println(String.format(DECIMAL_FORMAT, sinRiesgos));
    }

    /**
     * 
     */
    public void cuerposSinRiesgo() {
        StringBuilder sinRiesgos = new StringBuilder();
        for (CuerpoDeAgua cuerpo : cuerpos) {
            if (CuerpoDeAgua.index(cuerpo.nivel()) == 0) {
                sinRiesgos.append(cuerpo.nombre).append(" ");
            }
        }

        if (sinRiesgos.toString().trim().isEmpty()) {
            System.out.println("NA");
        } else {
            System.out.println(sinRiesgos.toString().trim());
        }
    }

    /**
     * 
     */
    public void ircaPromedio() {
        float suma = 0;
        for (CuerpoDeAgua cuerpoDeAgua : cuerpos) {
            suma += cuerpoDeAgua.irca;
        }
        System.out.println(String.format(DECIMAL_FORMAT, (suma / cuerpos.size())));
    }

    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        reto2 actividad = new reto2();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        try {
            int lecturas = Integer.parseInt(lector.readLine());
            for (int i = 0; i < lecturas; i++) {
                String data = lector.readLine();
                actividad.anadirCuerpo(data);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error al leer los datos de entrada");
        } catch (IOException e) {
            System.out.println("Error general del aplicativo");
        }
        actividad.ircaIndividual();
        actividad.cuerposBajosSinRiesgo();
        actividad.cuerposSinRiesgo();
        actividad.ircaPromedio();
    }
}
