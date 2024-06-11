package com.problema4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        palabras.add("programacion");
        palabras.add("java");
        palabras.add("computadora");
        palabras.add("consola");
        palabras.add("juego");

        Random random = new Random();
        String palabraSecreta = palabras.get(random.nextInt(palabras.size()));
        char[] estadoPalabra = new char[palabraSecreta.length()];
        for (int i = 0; i < estadoPalabra.length; i++) {
            estadoPalabra[i] = '_';
        }

        int intentosRestantes = 6;
        List<Character> letrasAdivinadas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (intentosRestantes > 0 && new String(estadoPalabra).contains("_")) {
            System.out.println("Palabra: " + new String(estadoPalabra));
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.print("Ingrese una letra: ");
            char letra = scanner.next().toLowerCase().charAt(0);

            if (letrasAdivinadas.contains(letra)) {
                System.out.println("Ya has adivinado esa letra.");
                continue;
            }

            letrasAdivinadas.add(letra);

            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    estadoPalabra[i] = letra;
                    acierto = true;
                }
            }

            if (!acierto) {
                intentosRestantes--;
                System.out.println("Letra incorrecta.");
            }

            System.out.println();
        }

        if (new String(estadoPalabra).equals(palabraSecreta)) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("Lo siento, te has quedado sin intentos. La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }
}