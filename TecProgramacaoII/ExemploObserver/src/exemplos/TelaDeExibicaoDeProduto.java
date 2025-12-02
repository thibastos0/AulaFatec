package exemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaDeExibicaoDeProduto extends JPanel implements ObservadorDeProduto {

    private final Produto produto;
    private final JLabel lblPreco = new JLabel();
    private final JLabel lblQtd = new JLabel();

    public TelaDeExibicaoDeProduto(Produto produto) {
        this.produto = produto;
        produto.adicionarObservador(this);

        setLayout(new GridLayout(4, 2, 5, 5));
        setBorder(BorderFactory.createTitledBorder(produto.getNome()));

        JLabel lblNome = new JLabel("Produto: " + produto.getNome());
        lblPreco.setText(String.format("Preço atual: R$ %.2f", produto.getPreco()));
        lblQtd.setText("Quantidade atual: " + produto.getQuantidade());

        JTextField campoPreco = new JTextField(String.valueOf(produto.getPreco()));
        JTextField campoQtd = new JTextField(String.valueOf(produto.getQuantidade()));
        JButton btnAtualizar = new JButton("Atualizar");

        add(lblNome);
        add(new JLabel());
        add(lblPreco);
        add(lblQtd);
        add(new JLabel("Novo Preço:"));
        add(campoPreco);
        add(new JLabel("Nova Quantidade:"));
        add(campoQtd);
        add(btnAtualizar);

        btnAtualizar.addActionListener((ActionEvent e) -> {
            try {
                double novoPreco = Double.parseDouble(campoPreco.getText());
                int novaQtd = Integer.parseInt(campoQtd.getText());
                produto.setPreco(novoPreco);
                produto.setQuantidade(novaQtd);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    @Override
    public void atualizar(Produto produto) {
        lblPreco.setText(String.format("Preço atual: R$ %.2f", produto.getPreco()));
        lblQtd.setText("Quantidade atual: " + produto.getQuantidade());
    }
}

