package br.com.logap.dao;

import org.hibernate.HibernateException;

import br.com.logap.dominio.Pessoa;

/**
 * Classe responsável pela persistência e consulta dos objetos do tipo Pessoa.
 * 
 * @author Anderson Santos
 *
 */
public class PessoaDAO extends PadraoDAO<Pessoa> {
	/**
	 * Método usado para buscar a pessoa pelo id.
	 * 
	 * @param id
	 * @return
	 * @throws HibernateException
	 * @throws IndexOutOfBoundsException
	 */
	public Pessoa buscarPorId(long id) throws HibernateException, IndexOutOfBoundsException {
		return super.buscarPorId(id, Pessoa.class);
	}
}
