import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double numero1, numero2, resultado;
        char operacao;

        System.out.print("Digite o primeiro número: ");
        numero1 = entrada.nextDouble();

        System.out.print("Digite o segundo número: ");
        numero2 = entrada.nextDouble();

        System.out.print("Digite a operação (+, -, *, /): ");
        operacao = entrada.next().charAt(0);

        switch (operacao) {

            case '+':
                resultado = numero1 + numero2;
                System.out.println("Resultado: " + resultado);
                break;

            case '-':
                resultado = numero1 - numero2;
                System.out.println("Resultado: " + resultado);
                break;

            case '*':
                resultado = numero1 * numero2;
                System.out.println("Resultado: " + resultado);
                break;

            case '/':
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                    System.out.println("Resultado: " + resultado);
                } else {
                    System.out.println("Não é possível dividir por zero.");
                }
                break;

            default:
                System.out.println("Operação inválida.");
        }

        entrada.close();
    }
}