package exemploDecorator;
import exemploDecorator.tiposBebida.*;
import exemploDecorator.adicionais.*;

public class Main {

    public static void main(String[] args) {
        
        CafeCasa cafecasa = new CafeCasa();
        System.out.println(cafecasa.getDescricao() + " R$ " + cafecasa.valor());

        Acucar acucarDecorator = new Acucar(cafecasa);
        System.out.println(acucarDecorator.getDescricao() + " R$ " + acucarDecorator.valor());

        Leite leiteDecorator = new Leite(acucarDecorator);
        System.out.println(leiteDecorator.getDescricao() + ": R$ " + leiteDecorator.valor());

    }

}
