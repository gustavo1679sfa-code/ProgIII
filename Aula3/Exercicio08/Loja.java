public class Loja {
    public static void main(String[] args) {
        Produto[] produtos = new Produto[5];
        produtos[0] = new Livro("O Hobbit", 59.90, "7890001", "J. R. R. Tolkien");
        produtos[1] = new CD("Acústico MTV", 29.90, "7890002", 14);
        produtos[2] = new DVD("Matrix", 39.90, "7890003", 136);
        produtos[3] = new Livro("Clean Code", 89.90, "7890004", "Robert C. Martin");
        produtos[4] = new CD("Clube da Esquina", 34.90, "7890005", 21);

        System.out.println("=== Produtos da loja ===");
        imprimir(produtos);

        Produto mesmoCodigo = new DVD("Matrix", 39.90, "7890003", 136);
        Produto codigoDiferente = new DVD("Matrix", 39.90, "9999999", 136);

        System.out.println();
        System.out.println("=== Busca com mesmo código de barras ===");
        buscar(mesmoCodigo, produtos);
        System.out.println("=== Busca com código de barras diferente ===");
        buscar(codigoDiferente, produtos);
    }

    public static void imprimir(Produto[] produtos) {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public static int buscar(Produto produto, Produto[] produtos) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i].equals(produto)) {
                System.out.println("Produto encontrado na posição " + i);
                return i;
            }
        }
        System.out.println("Produto não encontrado.");
        return -1;
    }
}
