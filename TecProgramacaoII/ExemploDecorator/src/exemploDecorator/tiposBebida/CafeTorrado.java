package exemploDecorator.tiposBebida;

import exemploDecorator.Bebida;

public class CafeTorrado extends Bebida {

    public CafeTorrado (String descricao) {
        super(descricao);
    }

    @Override
    public double valor(){
        return 20.00;
    }

}
