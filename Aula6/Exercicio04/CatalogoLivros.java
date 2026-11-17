import java.util.ArrayList;
import java.util.Scanner;

public class CatalogoLivros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> livros = new ArrayList<>();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("=== Catálogo de Livros ===");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Pesquisar título");
            System.out.println("4 - Remover livro pelo índice");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine().trim();
                    if (titulo.isEmpty()) {
                        System.out.println("Título vazio. Livro não adicionado.");
                    } else {
                        livros.add(titulo);
                        System.out.println("Livro \"" + titulo + "\" adicionado com sucesso.");
                    }
                    break;
                case 2:
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println("[" + i + "] " + livros.get(i));
                        }
                        System.out.println("Listagem concluída: " + livros.size() + " livro(s).");
                    }
                    break;
                case 3:
                    System.out.print("Título para pesquisar: ");
                    String busca = sc.nextLine().trim();
                    int indice = -1;
                    for (int i = 0; i < livros.size(); i++) {
                        if (livros.get(i).equalsIgnoreCase(busca)) {
                            indice = i;
                            break;
                        }
                    }
                    if (indice >= 0) {
                        System.out.println("Livro encontrado no índice " + indice + ".");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Índice do livro a remover: ");
                    try {
                        int i = Integer.parseInt(sc.nextLine().trim());
                        if (i >= 0 && i < livros.size()) {
                            String removido = livros.remove(i);
                            System.out.println("Livro \"" + removido + "\" removido com sucesso.");
                        } else {
                            System.out.println("Índice inválido. Nenhum livro removido.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Índice inválido. Nenhum livro removido.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o catálogo.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}
