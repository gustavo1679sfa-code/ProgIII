import java.util.HashSet;
import java.util.Scanner;

public class PalavrasUnicas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> palavras = new HashSet<>();

        System.out.println("Digite palavras (digite \"fim\" para encerrar):");
        while (true) {
            System.out.print("> ");
            String palavra = sc.nextLine().trim();
            if (palavra.equalsIgnoreCase("fim")) {
                break;
            }
            if (!palavra.isEmpty()) {
                palavras.add(palavra);
            }
        }

        System.out.println("Palavras únicas:");
        for (String p : palavras) {
            System.out.println("- " + p);
        }

        if (palavras.contains("Java")) {
            System.out.println("A palavra \"Java\" foi digitada.");
        } else {
            System.out.println("A palavra \"Java\" não foi digitada.");
        }

        System.out.println("Quantidade de palavras distintas: " + palavras.size());
        sc.close();
    }
}
