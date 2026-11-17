import java.util.Scanner;

public class RegistroProduto {

    public static double lerPreco(String texto) {
        double preco = Double.parseDouble(texto.trim().replace(",", "."));
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        return preco;
    }

    public static int lerQuantidade(String texto) {
        int quantidade = Integer.parseInt(texto.trim());
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        return quantidade;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Descrição do produto: ");
            String descricao = sc.nextLine();
            System.out.print("Preço unitário: ");
            double preco = lerPreco(sc.nextLine());
            System.out.print("Quantidade em estoque: ");
            int quantidade = lerQuantidade(sc.nextLine());

            double total = preco * quantidade;
            System.out.println("Produto: " + descricao);
            System.out.printf("Valor total do estoque: R$ %.2f%n", total);
        } catch (NumberFormatException e) {
            System.out.println("Erro: valor numérico inválido. Preço deve ser um número e quantidade um inteiro.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Registro de produto encerrado.");
            sc.close();
        }
    }
}
