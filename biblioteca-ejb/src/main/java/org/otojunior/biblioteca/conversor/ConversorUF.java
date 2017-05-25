/**
 * 
 */
package org.otojunior.biblioteca.conversor;

import javax.persistence.AttributeConverter;

import org.otojunior.biblioteca.entidade.usuario.UF;

/**
 * @author 01456231650
 *
 */
public class ConversorUF implements AttributeConverter<UF, String> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String convertToDatabaseColumn(UF attribute) {
		return (attribute != null) ? attribute.getSigla() : null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UF convertToEntityAttribute(String dbData) {
		return (dbData != null) ? UF.pesquisarPorSigla(dbData) : null;
	}
}
