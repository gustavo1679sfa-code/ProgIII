import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Contador extends JFrame implements ActionListener {
    private int valor = 0;
    private JLabel lblValor;
    private JButton btnMais, btnMenos, btnZerar;

    public Contador() {
        criarComponentesJanela();
        setarAtributosJanela();
        adicionarListeners();
        atualizar();
    }

    private void criarComponentesJanela() {
        lblValor = new JLabel("0", JLabel.CENTER);
        lblValor.setFont(new Font("Arial", Font.BOLD, 40));
        btnMais = new JButton("+1");
        btnMenos = new JButton("-1");
        btnZerar = new JButton("Zerar");
    }

    private void setarAtributosJanela() {
        this.setTitle("Contador");
        this.setSize(300, 180);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(lblValor, BorderLayout.CENTER);
        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(btnMenos);
        painelBotoes.add(btnZerar);
        painelBotoes.add(btnMais);
        this.getContentPane().add(painelBotoes, BorderLayout.SOUTH);
    }

    private void adicionarListeners() {
        btnMais.addActionListener(this);
        btnMenos.addActionListener(this);
        btnZerar.addActionListener(this);
    }

    private void atualizar() {
        lblValor.setText(String.valueOf(valor));
        btnMenos.setEnabled(valor != 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMais) {
            valor++;
        } else if (e.getSource() == btnMenos) {
            valor--;
        } else if (e.getSource() == btnZerar) {
            valor = 0;
        }
        atualizar();
    }

    public static void main(String[] args) {
        Contador janela = new Contador();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
