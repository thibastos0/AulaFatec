package exemplos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

    private final JPanel painelDetalhes;
    private final JPanel painelResumo;

    public JanelaPrincipal() {
        super("Demonstração do Padrão Observer");

        setLayout(new BorderLayout(10, 10));

        // Painel de cadastro
        JPanel painelCadastro = new JPanel(new FlowLayout());
        painelCadastro.setBorder(BorderFactory.createTitledBorder("Cadastrar Produto"));

        JTextField txtNome = new JTextField(10);
        JTextField txtPreco = new JTextField(7);
        JTextField txtQtd = new JTextField(5);
        JButton btnAdicionar = new JButton("Adicionar Produto");

        painelCadastro.add(new JLabel("Nome:"));
        painelCadastro.add(txtNome);
        painelCadastro.add(new JLabel("Preço:"));
        painelCadastro.add(txtPreco);
        painelCadastro.add(new JLabel("Qtd:"));
        painelCadastro.add(txtQtd);
        painelCadastro.add(btnAdicionar);

        // Painel com telas detalhadas
        painelDetalhes = new JPanel(new GridLayout(0, 2, 10, 10));
        JScrollPane scrollDetalhes = new JScrollPane(painelDetalhes);
        scrollDetalhes.setBorder(BorderFactory.createTitledBorder("Telas de Detalhes"));

        // Painel de resumo (outro tipo de observador)
        painelResumo = new JPanel(new GridLayout(0, 1, 5, 5));
        painelResumo.setBorder(BorderFactory.createTitledBorder("Resumos de Produtos (Observadores)"));

        // Ação de adicionar
        btnAdicionar.addActionListener((ActionEvent e) -> {
            try {
                String nome = txtNome.getText().trim();
                double preco = Double.parseDouble(txtPreco.getText());
                int qtd = Integer.parseInt(txtQtd.getText());

                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Digite o nome do produto!", "Erro", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Produto produto = new Produto(nome, preco, qtd);

                // Cria dois observadores diferentes
                TelaDeExibicaoDeProduto tela = new TelaDeExibicaoDeProduto(produto);
                ResumoDeProduto resumo = new ResumoDeProduto(produto);

                painelDetalhes.add(tela);
                painelResumo.add(resumo);

                painelDetalhes.revalidate();
                painelResumo.revalidate();
                painelDetalhes.repaint();
                painelResumo.repaint();

                txtNome.setText("");
                txtPreco.setText("");
                txtQtd.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Preço e quantidade devem ser numéricos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Layout geral
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollDetalhes, painelResumo);
        split.setResizeWeight(0.7);

        add(painelCadastro, BorderLayout.NORTH);
        add(split, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JanelaPrincipal::new);
    }
}
