/**
 * 
 */
package org.otojunior.biblioteca.dao.livro;

import javax.ejb.Stateless;

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
}
