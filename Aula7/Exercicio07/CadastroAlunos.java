import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class CadastroAlunos {
    private static final String ARQUIVO = "alunos.txt";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println();
            System.out.println("=== Cadastro de Alunos ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Calcular média das notas");
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
                case 3: calcularMedia(); break;
                case 0: System.out.println("Encerrando o sistema."); break;
                default: System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    private static void cadastrar() {
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        System.out.print("Curso: ");
        String curso = sc.nextLine().trim();
        System.out.print("Nota: ");
        double nota;
        try {
            nota = Double.parseDouble(sc.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Nota inválida. Cadastro cancelado.");
            return;
        }
        if (nome.isEmpty() || curso.isEmpty() || nome.contains(";") || curso.contains(";")) {
            System.out.println("Nome e curso não podem ser vazios nem conter ';'. Cadastro cancelado.");
            return;
        }
        if (nota < 0 || nota > 10) {
            System.out.println("A nota deve estar entre 0 e 10. Cadastro cancelado.");
            return;
        }

        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(ARQUIVO, true));
            ps.println(nome + ";" + curso + ";" + nota);
            if (ps.checkError()) {
                System.out.println("Erro ao gravar o cadastro.");
            } else {
                System.out.println("Aluno cadastrado com sucesso.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível abrir o arquivo para gravação: " + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    private static boolean arquivoDisponivel() {
        File f = new File(ARQUIVO);
        if (!f.exists()) {
            System.out.println("O arquivo " + ARQUIVO + " não existe. Cadastre um aluno primeiro.");
            return false;
        }
        if (f.length() == 0) {
            System.out.println("O arquivo " + ARQUIVO + " está vazio.");
            return false;
        }
        return true;
    }

    private static void listar() {
        if (!arquivoDisponivel()) {
            return;
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(ARQUIVO)));
            String linha = br.readLine();
            int i = 1;
            while (linha != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    System.out.println(i + ". Nome: " + dados[0] + " | Curso: " + dados[1] + " | Nota: " + dados[2]);
                    i++;
                }
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo.");
            }
        }
    }

    private static void calcularMedia() {
        if (!arquivoDisponivel()) {
            return;
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(ARQUIVO)));
            double soma = 0;
            int quantidade = 0;
            String linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    try {
                        soma += Double.parseDouble(dados[2]);
                        quantidade++;
                    } catch (NumberFormatException e) {
                        System.out.println("Registro com nota inválida ignorado: " + linha);
                    }
                }
                linha = br.readLine();
            }
            if (quantidade == 0) {
                System.out.println("Nenhuma nota válida encontrada.");
            } else {
                System.out.printf("Média das notas de %d aluno(s): %.2f%n", quantidade, soma / quantidade);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo.");
            }
        }
    }
}
