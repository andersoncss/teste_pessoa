package br.com.logap.negocio;

import javax.inject.Inject;

import org.hibernate.HibernateException;

import br.com.logap.dao.PessoaDAO;
import br.com.logap.dominio.Pessoa;

/**
 * Processador que realiza o cadastro, alteração e remoção de pessoa.
 * 
 * @author Anderson Santos
 * 
 */
public class ProcessadorPessoa {
	/**
	 * DAO responsável pela persistência e consulta dos objetos do tipo Pessoa.
	 */
	@Inject
	private PessoaDAO pessoaDAO;
	
	/**
	 * Construtor vazio.
	 */
	public ProcessadorPessoa() {
	}
	
	/**
	 * Método usado para atualizar um objeto do tipo Pessoa. 
	 * 
	 * @param pessoa
	 * @return
	 * @throws HibernateException
	 */
	public boolean atualizar(Pessoa pessoa) throws HibernateException {
		return pessoaDAO.atualizar(pessoa);
	}
	
	/**
	 * Método usado para buscar um objeto do tipo Pessoa pelo seu Id.
	 * 
	 * @param id
	 * @return
	 * @throws HibernateException
	 * @throws IndexOutOfBoundsException
	 */
	public Pessoa buscarPorId(long id) throws HibernateException, IndexOutOfBoundsException {
		return pessoaDAO.buscarPorId(id);
	}
	
	/**
	 * Método usado para inserir um objeto do tipo Pessoa.
	 * 
	 * @param pessoa
	 * @return
	 * @throws HibernateException
	 */
	public boolean inserir(Pessoa pessoa) throws HibernateException {
		return pessoaDAO.inserir(pessoa);
	}
	
	/**
	 * Método usado para remover um objeto do tipo Pessoa.
	 * 
	 * @param pessoa
	 * @return
	 * @throws HibernateException
	 */
	public boolean remover(Pessoa pessoa) throws HibernateException {
		return pessoaDAO.remover(pessoa);
	}
}
