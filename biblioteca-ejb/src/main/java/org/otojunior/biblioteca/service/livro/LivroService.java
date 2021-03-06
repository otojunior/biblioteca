/**
 * 
 */
package org.otojunior.biblioteca.service.livro;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.otojunior.biblioteca.dao.livro.LivroDao;
import org.otojunior.biblioteca.entidade.livro.Livro;
import org.otojunior.biblioteca.service.ServiceBase;

/**
 * @author 01456231650
 *
 */
@Stateless
public class LivroService extends ServiceBase {
	@EJB
	private LivroDao dao;
	
	/**
	 * 
	 * @param livro
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void persistir(Livro livro) {
		dao.persistir(livro);
	}
	
	/**
	 * 
	 * @param editora
	 * @return
	 */
	public List<Livro> pesquisar(String nome, String editora) {
		return dao.pesquisar(nome, editora);
	}
}
