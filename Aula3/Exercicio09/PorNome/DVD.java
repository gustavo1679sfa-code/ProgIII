public class DVD extends Produto {
    private int duracao;

    public DVD(String nome, double preco, String codigoBarras, int duracao) {
        super(nome, preco, codigoBarras);
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "[DVD] " + super.toString() + " | Duração: " + duracao + " min";
    }
}
