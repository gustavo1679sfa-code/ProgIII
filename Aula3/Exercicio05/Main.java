public class Main {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        System.out.println("2 + 3 = " + c.somar(2, 3));
        System.out.println("2.5 + 3.7 = " + c.somar(2.5, 3.7));
        System.out.println("1 + 2 + 3 = " + c.somar(1, 2, 3));
    }
}
