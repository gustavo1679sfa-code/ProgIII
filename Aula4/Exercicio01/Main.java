public class Main {
    public static void main(String[] args) {
        ContaBancaria[] contas = {
            new ContaCorrente(1, "Gustavo"),
            new ContaPoupanca(2, "Ryan")
        };

        for (ContaBancaria c : contas) {
            c.depositar(100);
            System.out.println("Após depósito de R$ 100,00: " + c);
            System.out.println("Saque de R$ 50,00: " + (c.sacar(50) ? "realizado" : "negado"));
            System.out.println(c);
            System.out.println("Saque de R$ 50,00: " + (c.sacar(50) ? "realizado" : "negado"));
            System.out.println(c);
            System.out.println();
        }
    }
}
