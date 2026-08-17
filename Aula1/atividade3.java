public class Main {
    public static void main(String[] args) {

        int primeiro = 1;
        int segundo = 1;

        for (int i = 1; i <= 30; i++) {
            System.out.print(primeiro + " ");

            int proximo = primeiro + segundo;
            primeiro = segundo;
            segundo = proximo;
        }
    }
}