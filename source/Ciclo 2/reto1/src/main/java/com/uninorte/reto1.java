package com.uninorte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reto1 {
    private final int[] categoryCount = new int[5];

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < categoryCount.length; i++) {
            message.append(getCategoryName(i)).append(": ").append(categoryCount[i]).append("\n");
        }
        return message.toString();
    }

    public reto1() {
        for (int i = 0; i < categoryCount.length; i++) {
            categoryCount[i] = 0;
        }
    }

    public void addCategoryCount(int category) {
        categoryCount[category] += 1;
    }

    public static int category(float ircaMeasure) {
        if (ircaMeasure <= 5) {
            return 0;
        } else {
            if (ircaMeasure <= 14) {
                return 1;
            } else {
                if (ircaMeasure <= 35) {
                    return 2;
                } else {
                    if (ircaMeasure <= 80) {
                        return 3;
                    } else {
                        return 4;
                    }
                }
            }
        }
    }

    public static String getCategoryName(int ircaCategory) {
        String categoryRisk = "";
        categoryRisk = switch (ircaCategory) {
            case 0 -> "SIN RIESGO";
            case 1 -> "BAJO";
            case 2 -> "MEDIO";
            case 3 -> "ALTO";
            default -> "INVIABLE SANITARIAMENTE";
        };
        return categoryRisk;
    }

    public int favorite() {
        int fav = 0;
        int count = categoryCount[0];
        for (int i = 0; i < categoryCount.length; i++) {
            if (count < categoryCount[i]) {
                fav = i;
                count = categoryCount[i];
            }
        }
        return fav;
    }

    public static void main(String[] args) throws Exception {
        reto1 classifier = new reto1();
        float suma = 0;
        int measures = 1;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        try {
            measures = Integer.parseInt(lector.readLine());
            String data = lector.readLine();
            String[] readings = data.split(" ");
            for (String reading : readings) {
                float measure = Float.parseFloat(reading);
                suma += measure;
                int ircaCategory = category(measure);
                classifier.addCategoryCount(ircaCategory);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer los datos de entrada");
        }

        suma /= measures;
        System.out.println(getCategoryName(category(suma)));
        System.out.println(String.format("%3.2f", suma));
        System.out.println(getCategoryName(classifier.favorite()));
    }
}