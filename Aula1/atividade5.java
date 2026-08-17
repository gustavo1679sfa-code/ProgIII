import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o início do intervalo: ");
        int inicio = entrada.nextInt();

        System.out.print("Digite o fim do intervalo: ");
        int fim = entrada.nextInt();

        System.out.println("Números primos:");

        for (int numero = inicio; numero <= fim; numero++) {

            boolean primo = true;

            if (numero < 2) {
                primo = false;
            }

            for (int divisor = 2; divisor < numero; divisor++) {

                if (numero % divisor == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                System.out.println(numero);
            }
        }

        entrada.close();
    }
}