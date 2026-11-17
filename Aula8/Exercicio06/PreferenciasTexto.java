import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PreferenciasTexto extends JFrame implements ItemListener {
    private JLabel lblTexto;
    private JCheckBox chkNegrito, chkItalico;
    private JRadioButton rdPequeno, rdMedio, rdGrande;
    private ButtonGroup grupoTamanho;

    public PreferenciasTexto() {
        criarComponentesJanela();
        setarAtributosJanela();
        adicionarListeners();
        atualizarFonte();
    }

    private void criarComponentesJanela() {
        lblTexto = new JLabel("Programação III", JLabel.CENTER);
        chkNegrito = new JCheckBox("Negrito");
        chkItalico = new JCheckBox("Itálico");
        rdPequeno = new JRadioButton("Pequeno");
        rdMedio = new JRadioButton("Médio", true);
        rdGrande = new JRadioButton("Grande");
        grupoTamanho = new ButtonGroup();
        grupoTamanho.add(rdPequeno);
        grupoTamanho.add(rdMedio);
        grupoTamanho.add(rdGrande);
    }

    private void setarAtributosJanela() {
        this.setTitle("Preferências de Texto");
        this.setSize(420, 220);
        this.setLocationRelativeTo(null);

        JPanel painelEstilo = new JPanel(new FlowLayout());
        painelEstilo.add(chkNegrito);
        painelEstilo.add(chkItalico);

        JPanel painelTamanho = new JPanel(new FlowLayout());
        painelTamanho.add(rdPequeno);
        painelTamanho.add(rdMedio);
        painelTamanho.add(rdGrande);

        JPanel painelControles = new JPanel(new GridLayout(2, 1));
        painelControles.add(painelEstilo);
        painelControles.add(painelTamanho);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(lblTexto, BorderLayout.CENTER);
        this.getContentPane().add(painelControles, BorderLayout.SOUTH);
    }

    private void adicionarListeners() {
        chkNegrito.addItemListener(this);
        chkItalico.addItemListener(this);
        rdPequeno.addItemListener(this);
        rdMedio.addItemListener(this);
        rdGrande.addItemListener(this);
    }

    private void atualizarFonte() {
        int estilo = Font.PLAIN;
        if (chkNegrito.isSelected()) {
            estilo += Font.BOLD;
        }
        if (chkItalico.isSelected()) {
            estilo += Font.ITALIC;
        }

        int tamanho = 20;
        if (rdPequeno.isSelected()) {
            tamanho = 12;
        } else if (rdGrande.isSelected()) {
            tamanho = 32;
        }

        lblTexto.setFont(new Font("Arial", estilo, tamanho));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        atualizarFonte();
    }

    public static void main(String[] args) {
        PreferenciasTexto janela = new PreferenciasTexto();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
