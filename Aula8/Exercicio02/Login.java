import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    private JLabel lblUsuario, lblSenha;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;

    public Login() {
        criarComponentesJanela();
        setarAtributosJanela();
        adicionarListeners();
    }

    private void criarComponentesJanela() {
        lblUsuario = new JLabel("Usuário:");
        lblSenha = new JLabel("Senha:");
        txtUsuario = new JTextField(15);
        txtSenha = new JPasswordField(15);
        txtSenha.setEchoChar('*');
        btnEntrar = new JButton("Entrar");
    }

    private void setarAtributosJanela() {
        this.setTitle("Login");
        this.setSize(320, 150);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new GridLayout(3, 2, 5, 5));
        this.getContentPane().add(lblUsuario);
        this.getContentPane().add(txtUsuario);
        this.getContentPane().add(lblSenha);
        this.getContentPane().add(txtSenha);
        this.getContentPane().add(new JLabel());
        this.getContentPane().add(btnEntrar);
    }

    private void adicionarListeners() {
        btnEntrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEntrar) {
            String usuario = txtUsuario.getText().trim();
            String senha = new String(txtSenha.getPassword());
            if (usuario.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha usuário e senha.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Bem-vindo(a), " + usuario + "!", "Login", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Login janela = new Login();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
