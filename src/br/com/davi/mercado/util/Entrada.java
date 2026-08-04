package br.com.davi.mercado.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    public static int lerInteiro(Scanner scanner, String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem);

            try {
                int valor = scanner.nextInt();
                scanner.nextLine();

                if (valor < min || valor > max) {
                    System.out.println("Digite um valor que está disponivel no menu " + min + " a " + max);
                    continue;
                }
                return valor;

            } catch (InputMismatchException e) {
                System.out.println(
                        "Digite apenas números para escolher o menu."
                );
                scanner.nextLine();
            }
        }
    }
    public static double lerDouble(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);

            try {
                double valor = scanner.nextDouble();
                scanner.nextLine();
                return valor;

            } catch (InputMismatchException e) {
                System.out.println("Digite apenas valores reais, contendo numeros.");
                scanner.nextLine();
            }
        }
    }
    public static String lerString(Scanner scanner, String mensagem) {

        System.out.print(mensagem);

        return scanner.nextLine();
    }
}