public class CD extends Produto {
    private int numeroFaixas;

    public CD(String nome, double preco, int numeroFaixas) {
        super(nome, preco);
        this.numeroFaixas = numeroFaixas;
    }

    @Override
    public String toString() {
        return "[CD] " + super.toString() + " | Faixas: " + numeroFaixas;
    }
}
