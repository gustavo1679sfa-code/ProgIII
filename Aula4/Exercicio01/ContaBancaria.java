public abstract class ContaBancaria {
    private int numero;
    private String titular;
    protected double saldo;

    public ContaBancaria(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    public abstract boolean sacar(double valor);

    public abstract void depositar(double valor);

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + numero + " | Titular: " + titular + " | Saldo: R$ " + String.format("%.2f", saldo);
    }
}
