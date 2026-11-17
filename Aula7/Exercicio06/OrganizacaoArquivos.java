import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OrganizacaoArquivos {
    private static Scanner sc = new Scanner(System.in);
    private static File diretorio;

    public static void main(String[] args) {
        System.out.print("Digite o caminho do diretório: ");
        diretorio = new File(sc.nextLine().trim());

        int opcao = -1;
        while (opcao != 0) {
            System.out.println();
            System.out.println("=== Diretório: " + diretorio.getPath() + " ===");
            System.out.println("1 - Verificar se o diretório existe");
            System.out.println("2 - Criar o diretório");
            System.out.println("3 - Listar arquivos e subdiretórios");
            System.out.println("4 - Exibir caminho absoluto e tamanho dos arquivos");
            System.out.println("5 - Criar novo arquivo de texto");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }

            switch (opcao) {
                case 1: verificar(); break;
                case 2: criarDiretorio(); break;
                case 3: listar(); break;
                case 4: detalhar(); break;
                case 5: criarArquivo(); break;
                case 0: System.out.println("Encerrando."); break;
                default: System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    private static boolean diretorioValido() {
        if (!diretorio.exists()) {
            System.out.println("Operação não concluída: o diretório não existe. Use a opção 2 para criá-lo.");
            return false;
        }
        if (!diretorio.isDirectory()) {
            System.out.println("Operação não concluída: o caminho informado não é um diretório.");
            return false;
        }
        return true;
    }

    private static void verificar() {
        if (diretorio.isDirectory()) {
            System.out.println("O diretório existe.");
        } else if (diretorio.exists()) {
            System.out.println("O caminho existe, mas é um arquivo, não um diretório.");
        } else {
            System.out.println("O diretório não existe.");
        }
    }

    private static void criarDiretorio() {
        if (diretorio.exists()) {
            System.out.println("Operação não concluída: o caminho já existe.");
        } else if (diretorio.mkdirs()) {
            System.out.println("Diretório criado com sucesso.");
        } else {
            System.out.println("Operação não concluída: não foi possível criar o diretório.");
        }
    }

    private static void listar() {
        if (!diretorioValido()) {
            return;
        }
        File[] itens = diretorio.listFiles();
        if (itens == null || itens.length == 0) {
            System.out.println("O diretório está vazio.");
            return;
        }
        for (File item : itens) {
            String tipo = item.isDirectory() ? "[DIR] " : "[ARQ] ";
            System.out.println(tipo + item.getName());
        }
    }

    private static void detalhar() {
        if (!diretorioValido()) {
            return;
        }
        System.out.println("Caminho absoluto: " + diretorio.getAbsolutePath());
        File[] itens = diretorio.listFiles();
        boolean temArquivo = false;
        if (itens != null) {
            for (File item : itens) {
                if (item.isFile()) {
                    temArquivo = true;
                    System.out.println(item.getAbsolutePath() + " - " + item.length() + " bytes");
                }
            }
        }
        if (!temArquivo) {
            System.out.println("Não há arquivos neste diretório.");
        }
    }

    private static void criarArquivo() {
        if (!diretorioValido()) {
            return;
        }
        System.out.print("Nome do novo arquivo (ex: notas.txt): ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Operação não concluída: nome vazio.");
            return;
        }
        if (!nome.endsWith(".txt")) {
            nome += ".txt";
        }
        File novo = new File(diretorio, nome);
        try {
            if (novo.createNewFile()) {
                System.out.println("Arquivo criado: " + novo.getAbsolutePath());
            } else {
                System.out.println("Operação não concluída: o arquivo já existe.");
            }
        } catch (IOException e) {
            System.out.println("Operação não concluída: " + e.getMessage());
        }
    }
}
