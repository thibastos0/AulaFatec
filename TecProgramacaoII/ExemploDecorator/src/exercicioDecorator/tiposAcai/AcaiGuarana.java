package exercicioDecorator.tiposAcai;

import exercicioDecorator.Acai;

public class AcaiGuarana extends Acai {

    public AcaiGuarana(){
        super("Açaí com Guaraná");
    }

    @Override
    public double valor(){
        return 15.00;
    } 

}
