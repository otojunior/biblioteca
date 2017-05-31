/**
 * 
 */
package org.otojunior.biblioteca.dao.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

/**
 * @author 01456231650
 *
 */
public class ConstrutorWhereTest { 
	/**
	 * Test method for {@link org.otojunior.biblioteca.dao.util.ConstrutorWhere#criar(java.lang.StringBuilder, java.util.List)}.
	 */
	@Test
	public void testCriar() {
		StringBuilder jpql = new StringBuilder("select lv from Livro lv");
		List<Pair<String, Object>> filtros = Arrays.asList(
			Pair.of("lv.nome = :_nome", "teste"),
			Pair.of("lv.editora = :_editora", "teste"));
		jpql = ConstrutorWhere.criar(jpql, filtros);
		
		assertEquals(
			"select lv from Livro lv "
			+ "where lv.nome = :_nome and "
			+ "lv.editora = :_editora", 
			jpql.toString());
	}
}
