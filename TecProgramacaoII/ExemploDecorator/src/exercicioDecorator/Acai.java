package exercicioDecorator;

public abstract class Acai {

    private String descricao = "descrição não disponível";

    public Acai(String descricao){
        super();
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public abstract double getPreco();

}
