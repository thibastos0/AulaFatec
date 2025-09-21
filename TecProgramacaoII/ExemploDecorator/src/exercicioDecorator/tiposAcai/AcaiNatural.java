package exercicioDecorator.tiposAcai;

import exercicioDecorator.Acai;

public class AcaiNatural extends Acai{

    public AcaiNatural(){
        super("Açaí natural");
    }

    @Override
    public double valor(){
        return 12.50;
    }

}
