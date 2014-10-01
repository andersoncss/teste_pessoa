package br.com.logap.dao;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.logap.dominio.PadraoDominio;

/**
 * Classe responsável pelo padrão dos DAOs do sistema.
 * 
 * @author Anderson Santos
 *
 * @param <T>
 */
public class PadraoDAO<T extends PadraoDominio> {
	
	/**
	 * Sessão para operações;
	 */
	@Inject
	private Session sessao;
	
	/**
	 * Transação da sessão.
	 */
	private Transaction transacao;
	
	/**
	 * Construtor vazio.
	 */
	public PadraoDAO() {
		
	}

	
	/**
	 * Método usado para atualizar um objeto.
	 * 
	 * @param objeto
	 * @return
	 * @throws HibernateException
	 */
	public boolean atualizar(T objeto) throws HibernateException {
		iniciarOperacao();
		sessao.merge(objeto);
		encerrarOperacao();
		return true;
	}
	
	/**
	 * Método usado para inserir um objeto.
	 * 
	 * @param objeto
	 * @return
	 * @throws HibernateException
	 */
	public boolean inserir(T objeto) throws HibernateException {
		iniciarOperacao();
		sessao.persist(objeto);
		encerrarOperacao();
		return true;
	}
	
	/**
	 * Método usado para remover um objeto.
	 * 
	 * @param objeto
	 * @return
	 * @throws HibernateException
	 */
	public boolean remover(T objeto) throws HibernateException {
		iniciarOperacao();
		sessao.delete(objeto);
		encerrarOperacao();
		return true;
	}
	
	/**
     * Método usado para buscar um objeto pela chave primária.
     * 
     * @param id
     * @param classe
     * @return
	 * @throws HibernateException
	 * @throws IndexOutOfBoundsException
     */
	public T buscarPorIdClasse(long id, Class<T> classe) throws HibernateException, IndexOutOfBoundsException {
		
		iniciarOperacao();
		
		StringBuilder textoConsulta = new StringBuilder();
		textoConsulta.append("SELECT objeto FROM ");
		textoConsulta.append(classe.getSimpleName());
		textoConsulta.append(" objeto WHERE id = ");
		textoConsulta.append(id);
		
		Query consulta = (Query) sessao.createQuery(textoConsulta.toString());
		
		@SuppressWarnings("unchecked")
		T resultado = (T) consulta.uniqueResult();
		
		encerrarOperacao();
		
		return resultado;
	}	

	
	/**
	 * Método usado para iniciar uma operação com o banco de dados.
	 */
	private void iniciarOperacao() {
		transacao = sessao.beginTransaction();
	}
	
	/**
	 * Método usado para encerrar uma operação com o banco de dados.
	 */
	private void encerrarOperacao() {
		transacao.commit();
	}
}
