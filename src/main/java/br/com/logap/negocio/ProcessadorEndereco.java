package br.com.logap.negocio;

import org.hibernate.HibernateException;

import br.com.logap.dao.EnderecoDAO;
import br.com.logap.dominio.Endereco;

/**
 * Processador que realiza o cadastro, alteração e remoção de endereço.
 * 
 * @author Anderson Santos
 * 
 */
public class ProcessadorEndereco {
	/**
	 * DAO responsável pela persistência e consulta dos objetos do tipo Endereco.
	 */
	private EnderecoDAO enderedoDAO;
	
	/**
	 * Construtor vazio.
	 */
	public ProcessadorEndereco() {
		enderedoDAO = new EnderecoDAO();
	}
	
	/**
	 * Método usado para atualizar um objeto do tipo Endereco. 
	 * 
	 * @param endereco
	 * @return
	 * @throws HibernateException
	 */
	public boolean atualizar(Endereco endereco) throws HibernateException {
		return enderedoDAO.atualizar(endereco);
	}
	
	/**
	 * Método usado para buscar um objeto do tipo Endereco pelo seu Id.
	 * 
	 * @param id
	 * @return
	 * @throws HibernateException
	 * @throws IndexOutOfBoundsException
	 */
	public Endereco buscarPorId(long id) throws HibernateException, IndexOutOfBoundsException {
		return enderedoDAO.buscarPorId(id);
	}
	
	/**
	 * Método usado para inserir um objeto do tipo Endereco.
	 * 
	 * @param endereco
	 * @return
	 * @throws HibernateException
	 */
	public boolean inserir(Endereco endereco) throws HibernateException {
		return enderedoDAO.inserir(endereco);
	}
	
	/**
	 * Método usado para remover um objeto do tipo Endereco.
	 * 
	 * @param endereco
	 * @return
	 * @throws HibernateException
	 */
	public boolean remover(Endereco endereco) throws HibernateException {
		return enderedoDAO.remover(endereco);
	}
}
