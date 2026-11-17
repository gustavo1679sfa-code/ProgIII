import java.util.Scanner;

public class CadastroAlunos {

    public static String validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        return nome.trim();
    }

    public static int validarIdade(String texto) throws NumberFormatException, IllegalArgumentException {
        int idade = Integer.parseInt(texto.trim());
        if (idade < 0) {
            throw new IllegalArgumentException("A idade não pode ser negativa.");
        }
        return idade;
    }

    public static double validarNota(String texto) throws NumberFormatException, IllegalArgumentException {
        double nota = Double.parseDouble(texto.trim().replace(",", "."));
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        return nota;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aceitos = 0;
        int rejeitados = 0;
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {
            System.out.println("=== Novo cadastro ===");
            try {
                System.out.print("Nome: ");
                String nome = validarNome(sc.nextLine());
                System.out.print("Idade: ");
                int idade = validarIdade(sc.nextLine());
                System.out.print("Nota: ");
                double nota = validarNota(sc.nextLine());

                aceitos++;
                System.out.printf("Cadastro ACEITO: %s, %d anos, nota %.1f%n", nome, idade, nota);
            } catch (NumberFormatException e) {
                rejeitados++;
                System.out.println("Cadastro REJEITADO: digite um valor numérico válido para idade e nota.");
            } catch (IllegalArgumentException e) {
                rejeitados++;
                System.out.println("Cadastro REJEITADO: " + e.getMessage());
            } finally {
                System.out.print("Deseja cadastrar outro aluno? (s/n): ");
                continuar = sc.hasNextLine() ? sc.nextLine().trim() : "n";
            }
        }

        System.out.println();
        System.out.println("=== Resumo ===");
        System.out.println("Cadastros aceitos: " + aceitos);
        System.out.println("Cadastros rejeitados: " + rejeitados);
        sc.close();
    }
}
