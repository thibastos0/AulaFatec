package exercicioDecorator.coposAcai;

import exercicioDecorator.Acai;

public class Acai350ml extends Acai {

    public Acai350ml(){
        super("Açaí no copinho de 350ml");
    }

    @Override
    public double getPreco(){
        return 10.00;
    } 

}
