package exemploDecorator.tiposBebida;

import exemploDecorator.Bebida;

public class CafeCasa extends Bebida {

    public CafeCasa() {
        super("Café da Casa");
    }

    @Override
    public double valor() {
        return 15.00;
    }

}