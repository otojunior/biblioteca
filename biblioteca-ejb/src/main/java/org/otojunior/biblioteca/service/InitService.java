/**
 * 
 */
package org.otojunior.biblioteca.service;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.otojunior.biblioteca.aplicacao.entidade.Genero;
import org.otojunior.biblioteca.aplicacao.entidade.Livro;
import org.otojunior.biblioteca.aplicacao.entidade.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service de inicio da aplicação.
 * @author 01456231650
 *
 */
@Singleton
@Startup
public class InitService {
	private static Logger LOG = LoggerFactory.getLogger(InitService.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * 
	 */
	public InitService() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		Usuario u1 = new Usuario();
		u1.setNome("teste");
		u1.setDataNascimento(LocalDate.of(1980, 12, 25));
		u1.setGenero(Genero.MASCULINO);
		
		Usuario u2 = new Usuario();
		u2.setNome("teste2");
		u2.setDataNascimento(LocalDate.of(1982, 01, 01));
		u2.setGenero(Genero.FEMININO);
		
		entityManager.persist(u1);
		entityManager.persist(u2);
		LOG.info("");
	}
}
