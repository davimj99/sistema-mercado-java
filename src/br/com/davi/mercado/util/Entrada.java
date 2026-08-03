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
                    System.out.println("Digite um valor entre " + min + " e " + max);
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
}