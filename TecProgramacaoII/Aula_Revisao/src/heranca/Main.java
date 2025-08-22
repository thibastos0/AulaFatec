package heranca;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.nome = "Animal Genérico";
        animal.qtdPatas = 4;
        animal.especie = "Desoconhecida";

        Pato pato = new Pato();
        pato.nome = "Donald";
        pato.qtdPatas = 2;
        pato.especie = "selvagem";
        pato.corBico = "Amarelo";

        Vaca  vaca = new Vaca();
        vaca.nome = "Mimosa";
        vaca.qtdPatas = 3;
        vaca.especie = "Nelori";
        vaca.selo = true;

        animal.emitirSom();
        vaca.emitirSom();
        pato.emitirSom();

    }

}
