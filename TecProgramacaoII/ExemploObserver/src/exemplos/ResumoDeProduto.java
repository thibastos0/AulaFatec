package exemplos;

import javax.swing.*;
import java.awt.*;

public class ResumoDeProduto extends JPanel implements ObservadorDeProduto {

    private final JLabel lblResumo = new JLabel();

    public ResumoDeProduto(Produto produto) {
        produto.adicionarObservador(this);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        atualizar(produto);
    }

    @Override
    public void atualizar(Produto produto) {
        lblResumo.setText(String.format("%s → R$ %.2f → %d ", produto.getNome(), produto.getPreco(), produto.getQuantidade()));
        add(lblResumo, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
