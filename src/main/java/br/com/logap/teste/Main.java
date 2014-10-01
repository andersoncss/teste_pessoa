package br.com.logap.teste;

import br.com.logap.util.WeldContext;

/**
 * Classe principal.
 * 
 * @author Anderson Santos
 *
 */
public class Main {
	/**
	 * Método que inicia a aplicação.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Teste teste = WeldContext.INSTANCE.getBean(Teste.class);
		teste.executarTestes();
	}
}
