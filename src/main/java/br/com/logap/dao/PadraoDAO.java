package br.com.logap.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	 * Fábrica de sessões.
	 */
	private SessionFactory fabricaSessoes;
	
	/**
	 * Método usado para atualizar um objeto.
	 * 
	 * @param objeto
	 * @return
	 * @throws HibernateException
	 */
	public boolean atualizar(T objeto) throws HibernateException {
		getSessaoAtual().merge(objeto);
		
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
		getSessaoAtual().persist(objeto);
		
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
		getSessaoAtual().delete(objeto);
		
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
	protected T buscarPorId(long id, Class<T> classe) throws HibernateException, IndexOutOfBoundsException {
		StringBuilder textoConsulta = new StringBuilder();
		textoConsulta.append("SELECT objeto FROM ");
		textoConsulta.append(classe.getSimpleName());
		textoConsulta.append(" objeto WHERE id = ");
		textoConsulta.append(id);
		
		Query consulta = (Query) getSessaoAtual().createQuery(textoConsulta.toString());
		
		@SuppressWarnings("unchecked")
		T resultado = (T) consulta.uniqueResult();
		
		return resultado;
	}
	
	/**
	 * Método usado para obter a sessão atual.
	 * 
	 * @return
	 * @throws HibernateException
	 */
	protected Session getSessaoAtual() throws HibernateException {
    	return fabricaSessoes.getCurrentSession();
    }
}
