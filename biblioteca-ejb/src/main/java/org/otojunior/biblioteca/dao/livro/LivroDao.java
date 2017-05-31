/**
 * 
 */
package org.otojunior.biblioteca.dao.livro;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.otojunior.biblioteca.dao.DaoBase;
import org.otojunior.biblioteca.entidade.livro.Livro;

/**
 * @author 01456231650
 *
 */
@Stateless
public class LivroDao extends DaoBase<Livro> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Livro pesquisarPorId(Long id) {
		return getEntityManager().find(Livro.class, id);
	}
	
	/**
	 * 
	 * @param nome
	 * @return
	 */
	public List<Livro> pesquisarPorNome(String nome) {
		EntityManager em = getEntityManager();
		TypedQuery<Livro> query = em.createNamedQuery(Livro.NQ_PESQUISA_POR_NOME, Livro.class);
		query.setParameter("_nome", nome);
		return query.getResultList();
	}
	
	/**
	 * 
	 * @param editora
	 * @return
	 */
	public List<Livro> pesquisarPorEditora(String editora) {
		EntityManager em = getEntityManager();
		TypedQuery<Livro> query = em.createNamedQuery(Livro.NQ_PESQUISA_POR_EDITORA, Livro.class);
		query.setParameter("_editora", editora);
		return query.getResultList();
	}
}
