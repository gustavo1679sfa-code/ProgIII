public class CD extends Produto {
    private int numeroFaixas;

    public CD(String nome, double preco, String codigoBarras, int numeroFaixas) {
        super(nome, preco, codigoBarras);
        this.numeroFaixas = numeroFaixas;
    }

    @Override
    public String toString() {
        return "[CD] " + super.toString() + " | Faixas: " + numeroFaixas;
    }
}
