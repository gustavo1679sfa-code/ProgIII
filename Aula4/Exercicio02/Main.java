public class Main {
    public static void main(String[] args) {
        Usuario[] usuarios = {
            new Usuario("Ana", NivelAcesso.BASICO),
            new Usuario("Bruno", NivelAcesso.INTERMEDIARIO),
            new Usuario("Carla", NivelAcesso.ADMIN)
        };

        for (Usuario u : usuarios) {
            u.exibirMensagem();
        }
    }
}
