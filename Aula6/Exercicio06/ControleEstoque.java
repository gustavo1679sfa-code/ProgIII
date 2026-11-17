import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControleEstoque {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, Integer> estoque = new HashMap<>();

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println();
            System.out.println("=== Controle de Estoque ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Consultar quantidade");
            System.out.println("3 - Atualizar quantidade");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Exibir todos os produtos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: consultar(); break;
                case 3: atualizar(); break;
                case 4: remover(); break;
                case 5: exibir(); break;
                case 0: System.out.println("Encerrando o controle de estoque."); break;
                default: System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    private static String lerNome() {
        System.out.print("Nome do produto: ");
        return sc.nextLine().trim();
    }

    private static int lerQuantidade() {
        while (true) {
            System.out.print("Quantidade: ");
            try {
                int q = Integer.parseInt(sc.nextLine().trim());
                if (q < 0) {
                    System.out.println("A quantidade não pode ser negativa.");
                } else {
                    return q;
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro.");
            }
        }
    }

    private static void cadastrar() {
        String nome = lerNome();
        if (nome.isEmpty()) {
            System.out.println("Nome vazio. Produto não cadastrado.");
        } else if (estoque.containsKey(nome)) {
            System.out.println("Produto já cadastrado. Use a opção de atualizar.");
        } else {
            estoque.put(nome, lerQuantidade());
            System.out.println("Produto \"" + nome + "\" cadastrado.");
        }
    }

    private static void consultar() {
        String nome = lerNome();
        if (estoque.containsKey(nome)) {
            System.out.println(nome + ": " + estoque.get(nome) + " unidade(s).");
        } else {
            System.out.println("Produto \"" + nome + "\" não encontrado.");
        }
    }

    private static void atualizar() {
        String nome = lerNome();
        if (estoque.containsKey(nome)) {
            estoque.put(nome, lerQuantidade());
            System.out.println("Quantidade de \"" + nome + "\" atualizada para " + estoque.get(nome) + ".");
        } else {
            System.out.println("Produto \"" + nome + "\" não encontrado.");
        }
    }

    private static void remover() {
        String nome = lerNome();
        if (estoque.remove(nome) != null) {
            System.out.println("Produto \"" + nome + "\" removido.");
        } else {
            System.out.println("Produto \"" + nome + "\" não encontrado.");
        }
    }

    private static void exibir() {
        if (estoque.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Map.Entry<String, Integer> item : estoque.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue() + " unidade(s)");
        }
    }
}
