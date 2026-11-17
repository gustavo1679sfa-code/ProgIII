import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class CopiaArquivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Caminho do arquivo de origem: ");
        String origem = sc.nextLine().trim();
        System.out.print("Caminho do arquivo de destino: ");
        String destino = sc.nextLine().trim();

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(origem);
            os = new FileOutputStream(destino);

            byte[] buffer = new byte[1024];
            int lidos;
            long total = 0;
            while ((lidos = is.read(buffer)) != -1) {
                os.write(buffer, 0, lidos);
                total += lidos;
            }
            System.out.println("Cópia concluída: " + total + " bytes copiados para " + destino + ".");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado ou destino inacessível: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Falha de leitura ou escrita: " + e.getMessage());
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar os arquivos.");
            }
            sc.close();
        }
    }
}
