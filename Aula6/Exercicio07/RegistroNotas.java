import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RegistroNotas {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, List<Double>> alunos = new HashMap<>();

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println();
            System.out.println("=== Registro de Notas ===");
            System.out.println("1 - Cadastrar aluno / adicionar notas");
            System.out.println("2 - Listar alunos e médias");
            System.out.println("3 - Consultar aluno");
            System.out.println("4 - Remover aluno");
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
                case 2: listar(); break;
                case 3: consultar(); break;
                case 4: remover(); break;
                case 0: System.out.println("Encerrando o programa."); break;
                default: System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    private static double calcularMedia(List<Double> notas) {
        if (notas.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (double n : notas) {
            soma += n;
        }
        return soma / notas.size();
    }

    private static void cadastrar() {
        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome vazio. Cadastro cancelado.");
            return;
        }
        List<Double> notas = alunos.get(nome);
        if (notas == null) {
            notas = new ArrayList<>();
            alunos.put(nome, notas);
        }

        System.out.println("Digite as notas (0 a 10). Deixe em branco para terminar.");
        while (true) {
            System.out.print("Nota: ");
            String entrada = sc.nextLine().trim();
            if (entrada.isEmpty()) {
                break;
            }
            try {
                double nota = Double.parseDouble(entrada.replace(",", "."));
                if (nota < 0 || nota > 10) {
                    System.out.println("A nota deve estar entre 0 e 10.");
                } else {
                    notas.add(nota);
                }
            } catch (NumberFormatException e) {
                System.out.println("Nota inválida.");
            }
        }
        System.out.printf("%s possui %d nota(s). Média: %.2f%n", nome, notas.size(), calcularMedia(notas));
    }

    private static void listar() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (Map.Entry<String, List<Double>> a : alunos.entrySet()) {
            System.out.printf("%s | Notas: %s | Média: %.2f%n", a.getKey(), a.getValue(), calcularMedia(a.getValue()));
        }
    }

    private static void consultar() {
        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine().trim();
        if (alunos.containsKey(nome)) {
            List<Double> notas = alunos.get(nome);
            System.out.printf("%s | Notas: %s | Média: %.2f%n", nome, notas, calcularMedia(notas));
        } else {
            System.out.println("Aluno \"" + nome + "\" não encontrado.");
        }
    }

    private static void remover() {
        System.out.print("Nome do aluno a remover: ");
        String nome = sc.nextLine().trim();
        if (alunos.remove(nome) != null) {
            System.out.println("Aluno \"" + nome + "\" removido.");
            listar();
        } else {
            System.out.println("Aluno \"" + nome + "\" não encontrado.");
        }
    }
}
