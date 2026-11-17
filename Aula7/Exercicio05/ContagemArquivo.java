import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ContagemArquivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo de texto: ");
        String caminho = sc.nextLine().trim();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(caminho)));

            int linhas = 0;
            int palavras = 0;
            int caracteres = 0;
            String maiorLinha = "";
            int numeroMaiorLinha = 0;

            String linha = br.readLine();
            while (linha != null) {
                linhas++;
                caracteres += linha.length();
                String limpa = linha.trim();
                if (!limpa.isEmpty()) {
                    palavras += limpa.split("\\s+").length;
                }
                if (linha.length() > maiorLinha.length()) {
                    maiorLinha = linha;
                    numeroMaiorLinha = linhas;
                }
                linha = br.readLine();
            }

            System.out.println("Linhas: " + linhas);
            System.out.println("Palavras: " + palavras);
            System.out.println("Caracteres: " + caracteres);
            if (linhas > 0) {
                System.out.println("Maior linha (linha " + numeroMaiorLinha + ", " + maiorLinha.length() + " caracteres): " + maiorLinha);
            } else {
                System.out.println("O arquivo está vazio.");
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
            sc.close();
        }
    }
}
