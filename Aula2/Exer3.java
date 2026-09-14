import java.util.ArrayList;
import java.util.Iterator;

public class Exercicio3_Alunos {
    public static void main(String[] args) {
        ArrayList<String> alunos = new ArrayList<>();
        alunos.add("Ana");
        alunos.add("Bruno");
        alunos.add("Carla");
        alunos.add("Diego");
        alunos.add("Elisa");

        System.out.println("Lista original:");
        Iterator<String> it = alunos.iterator();
        while (it.hasNext()) {
            String nome = it.next();
            System.out.println(nome);
        }

        it = alunos.iterator();
        while (it.hasNext()) {
            String nome = it.next();
            if (nome.equals("Bruno")) {
                it.remove();
                break;
            }
        }

        System.out.println("\nLista atualizada:");
        for (String nome : alunos) {
            System.out.println(nome);
        }
    }
}