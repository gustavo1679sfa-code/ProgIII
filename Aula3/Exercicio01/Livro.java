public class Livro {
    private String titulo;
    private String autor;

    public Livro() {
        this.titulo = "Sem título";
        this.autor = "Desconhecido";
    }

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void exibir() {
        System.out.println("Título: " + titulo + " | Autor: " + autor);
    }
}
