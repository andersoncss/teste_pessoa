package br.com.logap.negocio;

import org.hibernate.HibernateException;

import br.com.logap.dao.PessoaDAO;
import br.com.logap.dominio.Pessoa;

public class ProcessadorPessoa {
	/**
	 * DAO responsável pela persistência e consulta dos objetos do tipo Pessoa.
	 */
	private PessoaDAO pessoaDAO;
	
	/**
	 * Construtor vazio.
	 */
	public ProcessadorPessoa() {
		pessoaDAO = new PessoaDAO();
	}
	
	/**
	 * Método usado para atualizar um objeto do tipo Endereco. 
	 * 
	 * @param pessoa
	 * @return
	 * @throws HibernateException
	 */
	public boolean atualizar(Pessoa pessoa) throws HibernateException {
		return pessoaDAO.atualizar(pessoa);
	}
	
	/**
	 * Método usado para buscar um objeto do tipo Endereco pelo seu Id.
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
	 * Método usado para inserir um objeto do tipo Endereco.
	 * 
	 * @param pessoa
	 * @return
	 * @throws HibernateException
	 */
	public boolean inserir(Pessoa pessoa) throws HibernateException {
		return pessoaDAO.inserir(pessoa);
	}
	
	/**
	 * Método usado para remover um objeto do tipo Endereco.
	 * 
	 * @param pessoa
	 * @return
	 * @throws HibernateException
	 */
	public boolean remover(Pessoa pessoa) throws HibernateException {
		return pessoaDAO.remover(pessoa);
	}
}
