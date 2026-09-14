class Produto {
    int id;
    String nome;
    double preco;

    Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    void aplicarDesconto(double porcentagem) {
        preco = preco - (preco * porcentagem / 100);
    }

    void exibirDetalhes() {
        System.out.printf("ID: %d | Nome: %s | Preço: R$ %.2f%n", id, nome, preco);
    }
}

public class Exercicio5_Produto {
    public static void main(String[] args) {
        Produto p1 = new Produto(1, "Notebook", 3000.00);
        Produto p2 = new Produto(2, "Mouse", 100.00);

        p1.aplicarDesconto(10);
        p2.aplicarDesconto(15);

        p1.exibirDetalhes();
        p2.exibirDetalhes();
    }
}