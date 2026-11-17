import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisaoSegura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("=== Teste " + i + " ===");
            try {
                System.out.print("Digite o dividendo: ");
                int a = sc.nextInt();
                System.out.print("Digite o divisor: ");
                int b = sc.nextInt();
                int resultado = a / b;
                System.out.println("Resultado: " + a + " / " + b + " = " + resultado);
            } catch (ArithmeticException e) {
                System.out.println("Erro: não é possível dividir por zero. Informe um divisor diferente de zero.");
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite apenas números inteiros.");
                sc.nextLine();
            }
            System.out.println();
        }
        sc.close();
    }
}
