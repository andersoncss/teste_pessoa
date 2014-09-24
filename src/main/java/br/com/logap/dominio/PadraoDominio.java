package br.com.logap.dominio;

/**
 * Classe que representa o padrão das classes de domínio.
 * 
 * @author Anderson Santos
 *
 */
public abstract class PadraoDominio {
	/**
	 * Metodo usado para obter o id do objeto.
	 * 
	 * @return
	 */
	public abstract int getId();
	
	/**
	 * Método usado para alterar o id do objeto.
	 * 
	 * @param id
	 */
	public abstract void setId(int id);
}
