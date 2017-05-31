/**
 * 
 */
package org.otojunior.biblioteca.dao.livro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.otojunior.biblioteca.dao.DaoBaseTest;
import org.otojunior.biblioteca.entidade.livro.Livro;
import org.otojunior.biblioteca.entidade.mock.LivroFabrica;
import org.powermock.reflect.Whitebox;

/**
 * @author 01456231650
 *
 */
public class LivroDaoTest extends DaoBaseTest {
	private LivroDao dao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		dao = new LivroDao();
		Whitebox.setInternalState(dao, EntityManager.class, getEntityManager());
	}
	
	/**
	 * Test method for {@link org.otojunior.biblioteca.dao.livro.LivroDao#pesquisarPorId(java.lang.Long)}.
	 */
	@Test
	public void testPesquisarPorId() {
		getEntityManager().getTransaction().begin();
		dao.persistir(LivroFabrica.criar());
		dao.persistir(LivroFabrica.criar());
		dao.persistir(LivroFabrica.criar());
		getEntityManager().getTransaction().commit();
		
		assertNotNull(dao.pesquisarPorId(1L));
	}

	/**
	 * Test method for {@link org.otojunior.biblioteca.dao.livro.LivroDao#pesquisarPorNome(java.lang.String)}.
	 */
	@Test
	public void testPesquisarPorNome() {
		/*
		 * Inserção de 10 livros, sendo que 5 deles terá o nome de "teste"
		 */
		getEntityManager().getTransaction().begin();
		for (int i = 0; i < 10; i++) {
			Livro livro = LivroFabrica.criar();
			if (i % 2 == 0) {
				livro.setNome("teste");
			}
			dao.persistir(livro);
		}
		getEntityManager().getTransaction().commit();
		
		assertEquals(5, dao.pesquisarPorNome("teste").size());
	}

	/**
	 * Test method for {@link org.otojunior.biblioteca.dao.livro.LivroDao#pesquisarPorEditora(java.lang.String)}.
	 */
	@Test
	public void testPesquisarPorEditora() {
		/*
		 * Inserção de 10 livros, sendo que 4 deles terá a editora com nome de "teste"
		 */
		getEntityManager().getTransaction().begin();
		for (int i = 0; i < 10; i++) {
			Livro livro = LivroFabrica.criar();
			if (i % 3 == 0) {
				livro.setEditora("teste");
			}
			dao.persistir(livro);
		}
		getEntityManager().getTransaction().commit();
		
		assertEquals(4, dao.pesquisarPorEditora("teste").size());
	}

}
