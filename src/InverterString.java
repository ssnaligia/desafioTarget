package src;
/* 5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;*/

import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite uma string para inverter: ");
        String original = entrada.nextLine();

        char[] caracteres = original.toCharArray();

        String invertida = "";
        for (int i = caracteres.length - 1; i >= 0; i--) {
            invertida += caracteres[i];
        }

        System.out.println("String Invertida: " + invertida);

        entrada.close();
    }
}
