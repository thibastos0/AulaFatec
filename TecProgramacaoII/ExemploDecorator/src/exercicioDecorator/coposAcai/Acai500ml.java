package exercicioDecorator.coposAcai;

import exercicioDecorator.Acai;

public class Acai500ml extends Acai {

    public Acai500ml(){
        super("Acai no copinho de 500ml");
    }

    @Override
    public double getPreco(){
        return 20.00;
    }

}
