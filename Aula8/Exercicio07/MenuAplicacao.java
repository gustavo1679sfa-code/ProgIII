import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuAplicacao extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menuArquivo, menuAbrir, menuAjuda;
    private JMenuItem miNovo, miAbrirTexto, miAbrirImagem, miSair, miSobre;
    private JTextField txtSelecionado;

    public MenuAplicacao() {
        criarComponentesJanela();
        setarAtributosJanela();
        adicionarListeners();
    }

    private void criarComponentesJanela() {
        menuBar = new JMenuBar();
        menuArquivo = new JMenu("Arquivo");
        menuAbrir = new JMenu("Abrir");
        menuAjuda = new JMenu("Ajuda");

        miNovo = new JMenuItem("Novo");
        miAbrirTexto = new JMenuItem("Arquivo de texto");
        miAbrirImagem = new JMenuItem("Imagem");
        miSair = new JMenuItem("Sair");
        miSobre = new JMenuItem("Sobre");

        txtSelecionado = new JTextField(25);
        txtSelecionado.setEditable(false);
    }

    private void setarAtributosJanela() {
        this.setTitle("Menu de Aplicação");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);

        menuAbrir.add(miAbrirTexto);
        menuAbrir.add(miAbrirImagem);

        menuArquivo.add(miNovo);
        menuArquivo.add(menuAbrir);
        menuArquivo.addSeparator();
        menuArquivo.add(miSair);

        menuAjuda.add(miSobre);

        menuBar.add(menuArquivo);
        menuBar.add(menuAjuda);
        this.setJMenuBar(menuBar);

        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 10, 40));
        this.getContentPane().add(new JLabel("Item escolhido:"));
        this.getContentPane().add(txtSelecionado);
    }

    private void adicionarListeners() {
        miNovo.addActionListener(this);
        miAbrirTexto.addActionListener(this);
        miAbrirImagem.addActionListener(this);
        miSair.addActionListener(this);
        miSobre.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miNovo) {
            txtSelecionado.setText("Arquivo > Novo");
        } else if (e.getSource() == miAbrirTexto) {
            txtSelecionado.setText("Arquivo > Abrir > Arquivo de texto");
        } else if (e.getSource() == miAbrirImagem) {
            txtSelecionado.setText("Arquivo > Abrir > Imagem");
        } else if (e.getSource() == miSobre) {
            txtSelecionado.setText("Ajuda > Sobre");
            JOptionPane.showMessageDialog(this, "Menu de Aplicação\nProgramação III", "Sobre", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == miSair) {
            txtSelecionado.setText("Arquivo > Sair");
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        MenuAplicacao janela = new MenuAplicacao();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
