public class Main {
    public static void main(String[] args) {
        Animal[] animais = { new Cachorro(), new Gato() };
        for (Animal a : animais) {
            a.emitirSom();
        }
    }
}
