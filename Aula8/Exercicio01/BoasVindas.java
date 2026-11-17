import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoasVindas extends JFrame implements ActionListener {
    private JLabel lblMensagem;
    private JButton btnFechar;

    public BoasVindas() {
        criarComponentesJanela();
        setarAtributosJanela();
        adicionarListeners();
    }

    private void criarComponentesJanela() {
        lblMensagem = new JLabel("Seja bem-vindo à Programação III!", JLabel.CENTER);
        lblMensagem.setFont(new Font("Arial", Font.BOLD, 18));
        btnFechar = new JButton("Fechar");
    }

    private void setarAtributosJanela() {
        this.setTitle("Janela de Boas-Vindas");
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout(10, 10));
        this.getContentPane().add(lblMensagem, BorderLayout.CENTER);
        JPanel painelBotao = new JPanel(new FlowLayout());
        painelBotao.add(btnFechar);
        this.getContentPane().add(painelBotao, BorderLayout.SOUTH);
    }

    private void adicionarListeners() {
        btnFechar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFechar) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        BoasVindas janela = new BoasVindas();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
