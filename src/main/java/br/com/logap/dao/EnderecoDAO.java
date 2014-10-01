package br.com.logap.dao;

import org.hibernate.HibernateException;

import br.com.logap.dominio.Endereco;

/**
 * Classe responsável pela persistência e consulta dos objetos do tipo Endereco.
 * 
 * @author Anderson Santos
 *
 */

public class EnderecoDAO extends PadraoDAO<Endereco> {
	/**
	 * Método usado para buscar o endereço pelo id.
	 * 
	 * @param id
	 * @return
	 * @throws HibernateException
	 * @throws IndexOutOfBoundsException
	 */
	public Endereco buscarPorId(long id) throws HibernateException, IndexOutOfBoundsException {
		return super.buscarPorIdClasse(id, Endereco.class);
	}
}
