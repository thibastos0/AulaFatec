package openClosed;

public class AprovaExameSangue implements AprovaExame{

    @Override
    public void aprovarSolicitacaoExame(Exame exame) {
        if(verificaCondicoesExame(exame)) {
            System.out.println("Exame de sangue aprovado.");
        }
    }

    @Override
    public boolean verificaCondicoesExame(Exame exame) {
        return "SANGUE".equals(exame.tipo);
    }

}
