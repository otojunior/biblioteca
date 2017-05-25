/**
 * 
 */
package org.otojunior.biblioteca.entidade.usuario;

/**
 * @author 01456231650
 *
 */
public enum UF {
	MINAS_GERAIS("Minas Gerais", "MG"),
	RIO_DE_JANEIRO("Rio de Janeiro", "RJ"),
	SAO_PAULO("São Paulo", "SP"),
	BAHIA("Bahia", "BA");
	
	private String nome;
	private String sigla;
	
	/**
	 * 
	 * @param nome
	 * @param sigla
	 */
	private UF(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSigla() {
		return sigla;
	}
	
	/**
	 * 
	 * @param sigla
	 * @return
	 */
	public static UF pesquisarPorSigla(String sigla) {
		UF encontrado = null;
		for (UF uf : UF.values()) {
			if (uf.getSigla().equals(sigla)) {
				encontrado = uf;
				break;
			}
		}
		return encontrado;
	}
}
