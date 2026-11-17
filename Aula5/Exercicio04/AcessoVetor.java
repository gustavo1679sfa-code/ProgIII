import java.util.InputMismatchException;
import java.util.Scanner;

public class AcessoVetor {
    public static void main(String[] args) {
        String[] nomes = { "Ana", "Bruno", "Carla", "Diego", "Elisa" };
        Scanner sc = new Scanner(System.in);
        String continuar;

        do {
            try {
                System.out.print("Digite um índice (0 a " + (nomes.length - 1) + "): ");
                int indice = sc.nextInt();
                System.out.println("Nome na posição " + indice + ": " + nomes[indice]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Erro: índice inexistente. Use valores entre 0 e " + (nomes.length - 1) + ".");
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número inteiro.");
            }
            sc.nextLine();
            System.out.print("Deseja consultar outro índice? (s/n): ");
            continuar = sc.nextLine().trim();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("Programa finalizado.");
        sc.close();
    }
}
