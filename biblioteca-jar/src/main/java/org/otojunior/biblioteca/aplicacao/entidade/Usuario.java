/**
 * 
 */
package org.otojunior.biblioteca.aplicacao.entidade;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.otojunior.biblioteca.base.entidade.EntidadeBase;

/**
 * @author 01456231650
 *
 */
@Entity
public class Usuario extends EntidadeBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6032559148522702150L;
	
	@NotNull
	@Column(nullable=false, length=50)
	private String nome;
	
	@NotNull
	@Column(nullable=false)
	private LocalDate dataNascimento;

	@NotNull
	@Column(nullable=false)
	private Genero genero;
	
	@Lob
	@Column(nullable=true)
	private Blob foto;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the dataNascimento
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the genero
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * @return the foto
	 */
	public Blob getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
}
