package exemplo1;

public class Main {
	
	public static void main(String[] args) {
		//poderia receber a nova edicao atraves de um recurso externo
		int novaEdicao = 5;
		RevistaInformatica revistaInformatica = new RevistaInformatica();		
		Assinante1 assinante1 = new Assinante1(revistaInformatica);
		
		revistaInformatica.setNovaEdicao(novaEdicao);
	}

}
