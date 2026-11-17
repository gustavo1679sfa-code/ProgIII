import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LeituraArquivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo de texto: ");
        String caminho = sc.nextLine().trim();

        BufferedReader br = null;
        try {
            InputStream is = new FileInputStream(caminho);
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            System.out.println("=== Conteúdo de " + caminho + " ===");
            String linha = br.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Não foi possível abrir ou ler o arquivo: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo.");
            }
            sc.close();
        }
    }
}
