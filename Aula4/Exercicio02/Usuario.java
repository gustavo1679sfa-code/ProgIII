public class Usuario {
    private String nome;
    private NivelAcesso nivel;

    public Usuario(String nome, NivelAcesso nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public NivelAcesso getNivel() {
        return nivel;
    }

    public void exibirMensagem() {
        switch (nivel) {
            case BASICO:
                System.out.println(nome + " (BÁSICO): acesso somente à visualização de conteúdos.");
                break;
            case INTERMEDIARIO:
                System.out.println(nome + " (INTERMEDIÁRIO): pode visualizar e editar conteúdos.");
                break;
            case ADMIN:
                System.out.println(nome + " (ADMIN): acesso total ao sistema, incluindo gerenciamento de usuários.");
                break;
        }
    }
}
