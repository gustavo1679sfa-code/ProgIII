import java.util.Scanner;

public class UsaContaPolimorfia {
    public static void main(String[] args) {
        Conta c = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual tipo de conta deseja criar para José?");
        System.out.println("1 - Conta");
        System.out.println("2 - Conta especial");
        System.out.println("3 - Conta poupança");
        int opcao = scan.nextInt();
        switch (opcao) {
            case 1:
                c = new Conta(1, "José");
                break;
            case 2:
                c = new ContaEspecial(1, "José", 100.00);
                break;
            case 3:
                c = new ContaPoupanca(1, "José");
                break;
            default:
                System.out.println("Opção inválida.");
                scan.close();
                return;
        }
        c.imprimirTipoConta();
        c.imprimirTipoConta("teste");

        c.depositar(200);
        System.out.println(c);

        System.out.println("Saque de R$ 250: " + (c.sacar(250) ? "realizado" : "negado"));
        System.out.println(c);

        if (c instanceof ContaPoupanca) {
            ((ContaPoupanca) c).reajustar(0.05);
            System.out.println("Após reajuste de 5%: " + c);
        }

        Conta outra = new Conta(1, "Maria");
        System.out.println("Comparação com outra Conta de mesmo número: " + c.equals(outra));
        scan.close();
    }
}
