public class Exercicio4_Strings {
    public static void main(String[] args) {
        String frase = "  Programação Orientada a Objetos com Java  ";

        String tratada = frase.trim();
        System.out.println("Frase tratada: \"" + tratada + "\"");

        System.out.println("Quantidade de caracteres: " + tratada.length());

        System.out.println("Maiúsculas: " + tratada.toUpperCase());

        String substituida = tratada.replace("Java", "Linguagem Java");
        System.out.println("Substituição: " + substituida);

        char caractere = tratada.charAt(5);
        System.out.println("Caractere no índice 5: " + caractere);
    }
}