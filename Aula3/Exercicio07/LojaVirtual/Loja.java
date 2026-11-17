public class Loja {
    public static void main(String[] args) {
        Produto[] produtos = new Produto[5];
        produtos[0] = new Livro("O Hobbit", 59.90, "J. R. R. Tolkien");
        produtos[1] = new CD("Acústico MTV", 29.90, 14);
        produtos[2] = new DVD("Matrix", 39.90, 136);
        produtos[3] = new Livro("Clean Code", 89.90, "Robert C. Martin");
        produtos[4] = new CD("Clube da Esquina", 34.90, 21);

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}
