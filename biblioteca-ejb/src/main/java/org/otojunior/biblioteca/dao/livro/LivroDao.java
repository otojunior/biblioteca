/**
 * 
 */
package org.otojunior.biblioteca.dao.livro;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
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
	 * @param editora
	 * @return
	 */
	public List<Livro> pesquisar(String nome, String editora) {
		TypedQuery<Livro> query = getEntityManager().createQuery(
			jpql(nome, editora), 
			Livro.class);
		
		if (StringUtils.isNotBlank(nome)) {
			query.setParameter("_nome", nome);
		}
		if (StringUtils.isNotBlank(editora)) {
			query.setParameter("_editora", editora);
		}
		
		return query.getResultList();
	}

	/**
	 * 
	 * @return
	 */
	public String jpql(String nome, String editora) {
		String jpql = "select lv from Livro lv where";
		
		boolean algumaClausula = false;
		if (StringUtils.isNotBlank(nome)) {
			jpql += " and lv.nome = :_nome";
			algumaClausula = true;
		}
		if (StringUtils.isNotBlank(editora)) {
			jpql += " and lv.editora = :_editora";
			algumaClausula = true;
		}
		
		jpql = (algumaClausula) ? 
			jpql.replace(" where and", " where") : 
			jpql.replace(" where", "");
		
		return jpql;
	}
}
