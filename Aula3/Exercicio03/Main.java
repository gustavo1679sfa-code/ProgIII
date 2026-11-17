public class Main {
    public static void main(String[] args) {
        Aluno a = new Aluno("Gustavo", 20, "2024001");
        a.exibir();

        a.setNome("Ryan");
        a.setIdade(21);
        a.setMatricula("2024002");

        System.out.println("Nome: " + a.getNome());
        System.out.println("Idade: " + a.getIdade());
        System.out.println("Matrícula: " + a.getMatricula());
    }
}
