import java.io.File;
import java.util.Scanner;

public class AnaliseArquivos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um caminho: ");
        File f = new File(sc.nextLine().trim());

        if (!f.exists()) {
            System.out.println("O recurso não existe.");
            sc.close();
            return;
        }

        System.out.println("O recurso existe.");
        System.out.println("Caminho absoluto: " + f.getAbsolutePath());

        if (f.isFile()) {
            System.out.println("Tipo: arquivo");
            System.out.println("Tamanho: " + f.length() + " bytes");
        } else if (f.isDirectory()) {
            System.out.println("Tipo: diretório");
            File[] itens = f.listFiles();
            if (itens == null || itens.length == 0) {
                System.out.println("O diretório está vazio.");
            } else {
                System.out.println("Conteúdo:");
                for (File item : itens) {
                    String tipo = item.isDirectory() ? "[DIR] " : "[ARQ] ";
                    System.out.println("  " + tipo + item.getName());
                }
            }
        }
        sc.close();
    }
}
