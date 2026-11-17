import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField txtNumero1, txtNumero2;
    private JComboBox<String> cmbOperacao;
    private JCheckBox chkJOptionPane;
    private JButton btnCalcular;
    private JLabel lblResultado;

    public Calculadora() {
        criarComponentesJanela();
        setarAtributosJanela();
        adicionarListeners();
    }

    private void criarComponentesJanela() {
        txtNumero1 = new JTextField(10);
        txtNumero2 = new JTextField(10);
        String[] operacoes = { "Somar", "Subtrair", "Multiplicar", "Dividir" };
        cmbOperacao = new JComboBox<>(operacoes);
        chkJOptionPane = new JCheckBox("Exibir em JOptionPane");
        btnCalcular = new JButton("Calcular");
        lblResultado = new JLabel("Resultado: ");
    }

    private void setarAtributosJanela() {
        this.setTitle("Calculadora");
        this.setSize(420, 260);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new GridLayout(6, 2, 5, 5));
        this.getContentPane().add(new JLabel("Número 1:"));
        this.getContentPane().add(txtNumero1);
        this.getContentPane().add(new JLabel("Número 2:"));
        this.getContentPane().add(txtNumero2);
        this.getContentPane().add(new JLabel("Operação:"));
        this.getContentPane().add(cmbOperacao);
        this.getContentPane().add(chkJOptionPane);
        this.getContentPane().add(new JLabel());
        this.getContentPane().add(new JLabel());
        this.getContentPane().add(btnCalcular);
        this.getContentPane().add(lblResultado);
    }

    private void adicionarListeners() {
        btnCalcular.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() != btnCalcular) {
            return;
        }
        double n1, n2;
        try {
            n1 = Double.parseDouble(txtNumero1.getText().trim().replace(",", "."));
            n2 = Double.parseDouble(txtNumero2.getText().trim().replace(",", "."));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite números válidos nos dois campos.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double resultado;
        switch (cmbOperacao.getSelectedIndex()) {
            case 0: resultado = n1 + n2; break;
            case 1: resultado = n1 - n2; break;
            case 2: resultado = n1 * n2; break;
            default:
                if (n2 == 0) {
                    JOptionPane.showMessageDialog(this, "Não é possível dividir por zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                resultado = n1 / n2;
        }

        String texto = "Resultado: " + resultado;
        if (chkJOptionPane.isSelected()) {
            lblResultado.setText("Resultado: ");
            JOptionPane.showMessageDialog(this, texto, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            lblResultado.setText(texto);
        }
    }

    public static void main(String[] args) {
        Calculadora janela = new Calculadora();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
