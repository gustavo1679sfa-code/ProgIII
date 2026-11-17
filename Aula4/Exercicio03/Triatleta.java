public class Triatleta extends Pessoa implements Corredor, Nadador, Ciclista {

    public Triatleta(String nome) {
        super(nome);
    }

    @Override
    public void correr() {
        System.out.println(nome + " está correndo 10 km.");
    }

    @Override
    public void nadar() {
        System.out.println(nome + " está nadando 1,5 km.");
    }

    @Override
    public void pedalar() {
        System.out.println(nome + " está pedalando 40 km.");
    }
}
