public class Conta {
    private int numero;
    private String nome_titular;
    private double saldo;

    public Conta(int numero, String nome_titular, double saldo) {
        this.numero = numero;
        this.nome_titular = nome_titular;
        this.saldo = saldo;
    }

    public Conta(int numero, String nome_titular) {
        this.numero = numero;
        this.nome_titular = nome_titular;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        this.saldo = this.getSaldo() + valor;
    }

    public boolean sacar(double valor) {
        if (this.getSaldo() >= valor) {
            this.saldo = this.saldo - valor;
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome_titular() {
        return nome_titular;
    }

    public void setNome_titular(String nome_titular) {
        this.nome_titular = nome_titular;
    }

    public void imprimirTipoConta() {
        System.out.println("Conta Comum");
    }

    public void imprimirTipoConta(String s) {
        System.out.println("Conta Comum - String recebida: " + s);
    }

    @Override
    public String toString() {
        return "Conta: " + this.numero + " | Titular: " + this.nome_titular + " | Saldo: R$ " + String.format("%.2f", this.saldo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o.getClass() != this.getClass()) {
            return false;
        } else if (((Conta) o).getNumero() != this.getNumero()) {
            return false;
        } else {
            return true;
        }
    }
}
