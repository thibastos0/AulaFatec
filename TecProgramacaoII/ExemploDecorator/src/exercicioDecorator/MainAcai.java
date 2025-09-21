package exercicioDecorator;

import exercicioDecorator.adicionais.Granola;
import exercicioDecorator.adicionais.Ninho;
import exercicioDecorator.tiposAcai.AcaiNatural;

public class MainAcai {

    public static void main(String[] args) {
        AcaiNatural acainatural = new AcaiNatural();
        System.out.println(acainatural.getDescricao() + ": R$" + acainatural.valor());

        Granola granolaDecorator = new Granola(acainatural);
        System.out.println(granolaDecorator.getDescricao() + ": R$" + granolaDecorator.valor());
    
        Ninho ninhoDecorator = new Ninho(granolaDecorator);
        System.out.println(ninhoDecorator.getDescricao() + ": R$" + ninhoDecorator.valor());
    
    }

}
