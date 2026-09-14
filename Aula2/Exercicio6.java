import java.util.ArrayList;
import java.util.Iterator;

class ContaBancaria {
    int numero;
    String titular;
    double saldo;

    ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }
}

public class Exercicio6_ContaBancaria {
    public static void main(String[] args) {
        ArrayList<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaBancaria(1001, "Maria Silva", 1500.50));
        contas.add(new ContaBancaria(1002, "João Souza", 3200.75));
        contas.add(new ContaBancaria(1003, "Pedro Lima", 800.00));

        double saldoTotal = 0;

        Iterator<ContaBancaria> it = contas.iterator();
        while (it.hasNext()) {
            ContaBancaria conta = it.next();
            System.out.println("Conta: " + conta.numero + " | Titular: " + conta.titular);
            saldoTotal += conta.saldo;
        }

        System.out.printf("%nSaldo total acumulado no banco: R$ %.2f%n", saldoTotal);
    }
}