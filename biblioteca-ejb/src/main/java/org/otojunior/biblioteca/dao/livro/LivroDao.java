/**
 * 
 */
package org.otojunior.biblioteca.dao.livro;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.otojunior.biblioteca.dao.DaoBase;
import org.otojunior.biblioteca.dao.util.ConstrutorWhere;
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
		StringBuilder jpql = new StringBuilder("select lv from Livro lv");
		
		
		List<Pair<String, Object>> filtros = Arrays.asList(
			Pair.of("lv.nome = :_nome", nome),
			Pair.of("lv.editora = :_editora", editora));
		
		jpql = ConstrutorWhere.criar(jpql, filtros);
		
		return null;
	}
}
