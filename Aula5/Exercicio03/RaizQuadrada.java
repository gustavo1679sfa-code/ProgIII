public class RaizQuadrada {

    public static double calcularRaiz(int numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("Não existe raiz quadrada real de número negativo (" + numero + ").");
        }
        return Math.sqrt(numero);
    }

    public static void main(String[] args) {
        int[] testes = { 0, 25, -9 };

        for (int n : testes) {
            try {
                double raiz = calcularRaiz(n);
                System.out.println("Raiz quadrada de " + n + " = " + raiz);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
