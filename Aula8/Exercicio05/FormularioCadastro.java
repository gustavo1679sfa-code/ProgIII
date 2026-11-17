import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormularioCadastro extends JFrame implements ActionListener {
    private JTextField txtNome, txtEmail, txtTelefone;
    private JButton btnSalvar, btnLimpar;

    public FormularioCadastro() {
        criarComponentesJanela();
        setarAtributosJanela();
        adicionarListeners();
    }

    private void criarComponentesJanela() {
        txtNome = new JTextField(20);
        txtEmail = new JTextField(20);
        txtTelefone = new JTextField(20);
        btnSalvar = new JButton("Salvar");
        btnLimpar = new JButton("Limpar");
    }

    private void setarAtributosJanela() {
        this.setTitle("Formulário de Cadastro");
        this.setSize(380, 200);
        this.setLocationRelativeTo(null);

        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 5, 5));
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(txtNome);
        painelCampos.add(new JLabel("E-mail:"));
        painelCampos.add(txtEmail);
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(txtTelefone);

        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnLimpar);

        this.getContentPane().setLayout(new BorderLayout(5, 5));
        this.getContentPane().add(painelCampos, BorderLayout.CENTER);
        this.getContentPane().add(painelBotoes, BorderLayout.SOUTH);
    }

    private void adicionarListeners() {
        btnSalvar.addActionListener(this);
        btnLimpar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalvar) {
            String nome = txtNome.getText().trim();
            String email = txtEmail.getText().trim();
            String telefone = txtTelefone.getText().trim();
            if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Nome: " + nome + "\nE-mail: " + email + "\nTelefone: " + telefone,
                        "Dados salvos", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == btnLimpar) {
            txtNome.setText("");
            txtEmail.setText("");
            txtTelefone.setText("");
            txtNome.requestFocus();
        }
    }

    public static void main(String[] args) {
        FormularioCadastro janela = new FormularioCadastro();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
