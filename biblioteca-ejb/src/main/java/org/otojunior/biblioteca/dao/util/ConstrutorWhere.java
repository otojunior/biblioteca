/**
 * 
 */
package org.otojunior.biblioteca.dao.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author 01456231650
 *
 */
public class ConstrutorWhere {

	/**
	 * 
	 * @param jpql
	 * @param filtros
	 * @return
	 */
	public static StringBuilder criar(StringBuilder jpql, List<Pair<String, Object>> filtros) {
		if (filtros.size() > 0) {
			boolean primeiro = false;
			boolean algumValido = false;
			for (Pair<String, Object> filtro : filtros) {
				if (isValido(filtro)) {
					algumValido = true;
					if (!primeiro) {
						primeiro = true;
						jpql.append(" where ");
					}
					String clausula = filtro.getKey();
					jpql.append(clausula).append(" and ");
				}
			}
			if (algumValido) {
				jpql.delete(jpql.length()-1-" and ".length(), jpql.length()-1);
			}
		}
		return jpql;
	}

	private static boolean isValido(Pair<String, Object> filtro) {
		boolean valido = false;
		Object valor = filtro.getValue();
		if (String.class.equals(valor.getClass())) {
			String valorstr = valor.toString();
			if (StringUtils.isNotBlank(valorstr)) {
				valido = true;
			}
		} else {
			if (valor != null) {
				valido = true;
			}
		}
		return valido;
	}

}
