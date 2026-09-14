import java.util.ArrayList;
import java.util.Iterator;

public class Exercicio7_CadastroPessoa {

    static boolean validarNome(String nome) {
        if (nome == null) {
            return false;
        }
        String nomeTratado = nome.trim();
        return !nomeTratado.isEmpty() && nomeTratado.length() >= 3;
    }

    static boolean buscarUsuario(ArrayList<String> lista, String busca) {
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            String nome = it.next();
            if (nome.equalsIgnoreCase(busca)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> usuarios = new ArrayList<>();

        String[] candidatos = {"Ana", "Bruno Costa", "Jo", "Carla Dias"};
        for (String nome : candidatos) {
            if (validarNome(nome)) {
                usuarios.add(nome);
            }
        }

        System.out.println("Usuários cadastrados: " + usuarios);

        String busca = "carla dias";
        boolean encontrado = buscarUsuario(usuarios, busca);
        System.out.println("Usuário \"" + busca + "\" encontrado? " + encontrado);
    }
}