import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class RegistroTexto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintStream ps = null;
        try {
            ps = new PrintStream("anotacoes.txt");
            System.out.println("Digite suas anotações (digite FIM para encerrar):");
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha.equals("FIM")) {
                    break;
                }
                ps.println(linha);
            }

            if (ps.checkError()) {
                System.out.println("Ocorreu um problema durante a gravação.");
            } else {
                System.out.println("Gravação concluída em anotacoes.txt.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível criar o arquivo: " + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            sc.close();
        }
    }
}
