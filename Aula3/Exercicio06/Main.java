public class Main {
    public static void main(String[] args) {
        ContaBancaria c1 = new ContaBancaria(100);
        ContaBancaria c2 = new ContaBancaria(100);
        ContaBancaria c3 = new ContaBancaria(200);

        System.out.println("c1.equals(c2): " + c1.equals(c2));
        System.out.println("c1.equals(c3): " + c1.equals(c3));
        System.out.println(c1);
    }
}
