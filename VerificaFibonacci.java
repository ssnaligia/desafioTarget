/*2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma 
dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem 
que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando 
se o número informado pertence ou não a sequência. */

import java.util.Scanner;

class VerificaFibonacci {
    public static void main(String[] args) {
        int num, a = 0, b = 1, fib = 0;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe um número: ");
        num = entrada.nextInt();

        if (num == 0 || num == 1) {
            System.out.printf("%d pertence à sequência de Fibonacci.\n", num);
        } else {
            while (fib < num) {
                fib = a + b;
                a = b;
                b = fib;
            }

            if (fib == num) {
                System.out.printf("%d pertence à sequência de Fibonacci.\n", num);
            } else {
                System.out.printf("%d não pertence à sequência de Fibonacci.\n", num);
            }
        }

        entrada.close();
    }
}
