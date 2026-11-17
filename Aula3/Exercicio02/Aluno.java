public class Aluno extends Pessoa {
    protected String matricula;

    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public void exibir() {
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Matrícula: " + matricula);
    }
}
