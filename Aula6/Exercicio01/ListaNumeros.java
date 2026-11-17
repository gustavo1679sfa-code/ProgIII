import java.util.ArrayList;
import java.util.Scanner;

public class ListaNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        while (numeros.size() < 10) {
            System.out.print("Digite o " + (numeros.size() + 1) + "º número inteiro: ");
            if (sc.hasNextInt()) {
                numeros.add(sc.nextInt());
            } else {
                System.out.println("Valor inválido. Digite um número inteiro.");
                sc.next();
            }
        }

        System.out.println("Números cadastrados: " + numeros);

        int soma = 0;
        for (int n : numeros) {
            soma += n;
        }
        double media = (double) soma / numeros.size();
        System.out.println("Soma: " + soma);
        System.out.printf("Média: %.2f%n", media);

        numeros.removeIf(n -> n % 2 == 0);
        System.out.println("Lista sem os números pares: " + numeros);
        sc.close();
    }
}
