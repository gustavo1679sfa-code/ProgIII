class Contador {
    static int totalObjetos = 0;

    Contador() {
        totalObjetos++;
    }

    static void mostrarTotal() {
        System.out.println("Total de objetos criados: " + totalObjetos);
    }
}

public class Exercicio2_Contador {
    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();
        Contador c4 = new Contador();

        Contador.mostrarTotal();
    }
}