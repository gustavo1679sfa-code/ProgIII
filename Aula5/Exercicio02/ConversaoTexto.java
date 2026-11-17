import java.util.Scanner;

public class ConversaoTexto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Digite um número inteiro: ");
            String texto = sc.nextLine();
            int numero = Integer.parseInt(texto.trim());
            System.out.println("Conversão realizada com sucesso! Valor: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Erro: o valor informado não é um número inteiro válido.");
        } finally {
            System.out.println("Encerrando programa...");
            sc.close();
        }
    }
}
