package openClosed;

public class AprovaRaioX implements AprovaExame {

    @Override
    public void aprovarSolicitacaoExame(Exame exame) {
        if(verificaCondicoesExame(exame)) {
            System.out.println("Exame de raio X aprovado.");
        }
    }

    @Override
    public boolean verificaCondicoesExame(Exame exame) {
        return "RAIO_X".equals(exame.tipo);
    }

}
