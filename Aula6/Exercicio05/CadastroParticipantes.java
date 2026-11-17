import java.util.HashSet;
import java.util.Scanner;

public class CadastroParticipantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> participantes = new HashSet<>();

        System.out.println("Digite os nomes dos participantes (digite \"fim\" para encerrar):");
        while (true) {
            System.out.print("> ");
            String nome = sc.nextLine().trim();
            if (nome.equalsIgnoreCase("fim")) {
                break;
            }
            if (nome.isEmpty()) {
                continue;
            }
            if (participantes.add(nome)) {
                System.out.println(nome + " registrado(a).");
            } else {
                System.out.println(nome + " já estava registrado(a). Nome repetido ignorado.");
            }
        }

        System.out.println("Participantes únicos:");
        for (String p : participantes) {
            System.out.println("- " + p);
        }
        System.out.println("Total de participantes distintos: " + participantes.size());

        System.out.print("Digite um nome para verificar a inscrição: ");
        String busca = sc.nextLine().trim();
        if (participantes.contains(busca)) {
            System.out.println(busca + " está inscrito(a).");
        } else {
            System.out.println(busca + " não está inscrito(a).");
        }
        sc.close();
    }
}
