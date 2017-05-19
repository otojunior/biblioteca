/**
 * 
 */
package org.otojunior.biblioteca.base.entidade;

import java.io.Serializable;

/**
 * @author 01456231650
 *
 */
public interface IEntidadeBase extends Serializable {
	/**
	 * 
	 * @return
	 */
	public Long getId();
	
	/**
	 * 
	 * @return
	 */
	public Long getVersao();
}
