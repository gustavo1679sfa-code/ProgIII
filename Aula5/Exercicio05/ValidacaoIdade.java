public class ValidacaoIdade {

    public static void validarIdade(int idade) throws IdadeInvalidaException {
        if (idade < 0) {
            throw new IdadeInvalidaException("Idade inválida: " + idade + ". A idade não pode ser negativa.");
        }
        System.out.println("Idade " + idade + " válida.");
    }

    public static void cadastrarPessoa(String nome, int idade) {
        try {
            validarIdade(idade);
            System.out.println("Cadastro de " + nome + " realizado com sucesso.");
        } catch (IdadeInvalidaException e) {
            System.out.println("Erro ao cadastrar " + nome + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        cadastrarPessoa("Ana", 25);
        cadastrarPessoa("Bruno", -3);

        System.out.println();
        System.out.println("throw: usado dentro do método para lançar efetivamente uma exceção.");
        System.out.println("throws: usado na assinatura do método para declarar que ele pode lançar uma exceção.");
    }
}
