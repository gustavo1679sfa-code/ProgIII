public class ContaCorrente extends ContaBancaria {
    private static final double TAXA_SAQUE = 1.00;

    public ContaCorrente(int numero, String titular) {
        super(numero, titular);
    }

    @Override
    public boolean sacar(double valor) {
        double total = valor + TAXA_SAQUE;
        if (valor > 0 && total <= saldo) {
            saldo -= total;
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
}
