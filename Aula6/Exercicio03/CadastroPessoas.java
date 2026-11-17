import java.util.HashMap;
import java.util.Scanner;

public class CadastroPessoas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> pessoas = new HashMap<>();

        System.out.println("=== Cadastro de 5 pessoas ===");
        while (pessoas.size() < 5) {
            System.out.print("Nome: ");
            String nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("O nome não pode ser vazio.");
                continue;
            }
            if (pessoas.containsKey(nome)) {
                System.out.println("Esse nome já está cadastrado.");
                continue;
            }
            System.out.print("Idade: ");
            try {
                int idade = Integer.parseInt(sc.nextLine().trim());
                pessoas.put(nome, idade);
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida. Cadastro não realizado.");
            }
        }

        System.out.print("Digite um nome para consultar: ");
        String consulta = sc.nextLine().trim();
        if (pessoas.containsKey(consulta)) {
            System.out.println(consulta + " tem " + pessoas.get(consulta) + " anos.");
        } else {
            System.out.println("O nome \"" + consulta + "\" não está cadastrado.");
        }

        System.out.print("Digite um nome para remover: ");
        String remover = sc.nextLine().trim();
        if (pessoas.containsKey(remover)) {
            pessoas.remove(remover);
            System.out.println(remover + " foi removido(a).");
        } else {
            System.out.println("O nome \"" + remover + "\" não está cadastrado.");
        }

        System.out.println("Mapa atualizado: " + pessoas);
        sc.close();
    }
}
