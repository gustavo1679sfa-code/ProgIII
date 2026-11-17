public class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(int numero, String nome_titular, double limite) {
        super(numero, nome_titular);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= this.limite + this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void imprimirTipoConta() {
        System.out.println("Conta Especial");
    }

    @Override
    public String toString() {
        return super.toString() + " | Limite: R$ " + String.format("%.2f", this.limite);
    }
}
