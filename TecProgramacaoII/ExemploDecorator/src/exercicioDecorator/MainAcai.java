package exercicioDecorator;

import exercicioDecorator.adicionais.*;
import exercicioDecorator.coposAcai.*;

public class MainAcai {

    public static void main(String[] args) {
        Acai acai400ml = new Acai400ml();
        System.out.println(acai400ml.getDescricao() + ": R$" + acai400ml.getPreco());

        acai400ml = new Granola(acai400ml, 1);
        System.out.println(acai400ml.getDescricao() + ": R$" + acai400ml.getPreco());
        
        acai400ml = new Ninho(acai400ml, 3);
        System.out.println(acai400ml.getDescricao() + ": R$" + acai400ml.getPreco());

        acai400ml = new Granola(acai400ml, 1);
        System.out.println(acai400ml.getDescricao() + ": R$" + acai400ml.getPreco());

        acai400ml = new Banana(acai400ml, 2);
        System.out.println(acai400ml.getDescricao() + ": R$" + acai400ml.getPreco());

    }

}
