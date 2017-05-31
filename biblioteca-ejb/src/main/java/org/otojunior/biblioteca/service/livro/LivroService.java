/**
 * 
 */
package org.otojunior.biblioteca.service.livro;

import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.commons.lang3.StringUtils;
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
	 * @param nome
	 * @return
	 */
	public List<Livro> pesquisarPorNome(String nome) {
		return dao.pesquisarPorNome(nome);
	}
	
	/**
	 * 
	 * @param editora
	 * @return
	 */
	public List<Livro> pesquisarPorEditora(String editora) {
		return dao.pesquisarPorEditora(editora);
	}
	
	/**
	 * @param nome
	 * @param editora
	 * @return
	 */
	public List<Livro> pesquisarPorNomeOuEditora(String nome, String editora) {
		List<Livro> resultado = Collections.emptyList();
		if (StringUtils.isNotBlank(nome) && StringUtils.isBlank(editora)) {
			resultado = pesquisarPorNome(nome);
		} else if (StringUtils.isBlank(nome) && StringUtils.isNotBlank(editora)) {
			resultado = pesquisarPorEditora(editora);
		}
		return resultado;
	}
}
