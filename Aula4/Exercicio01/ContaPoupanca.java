public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(int numero, String titular) {
        super(numero, titular);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
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
