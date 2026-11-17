public class Produto {
    private String nome;
    private double preco;
    private String codigoBarras;

    public Produto(String nome, double preco, String codigoBarras) {
        this.nome = nome;
        this.preco = preco;
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Preço: R$ " + String.format("%.2f", preco) + " | Código: " + codigoBarras;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Produto)) {
            return false;
        } else {
            return this.codigoBarras.equals(((Produto) o).getCodigoBarras());
        }
    }
}
