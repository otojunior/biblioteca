/**
 * 
 */
package org.otojunior.biblioteca.livro;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.otojunior.biblioteca.entidade.livro.Livro;
import org.otojunior.biblioteca.service.livro.LivroService;
import org.primefaces.event.ToggleSelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author otojunior
 *
 */
@ManagedBean
@ViewScoped
public class LivroView {
	private static final Logger LOG = LoggerFactory.getLogger(LivroView.class);
	
	// Pesquisa
	private String nome;
	private String editora;
	
	// Listagem
	private List<Livro> livros;
	private List<Livro> selecionados;
	
	@Inject
	private LivroService service;
	
	/**
	 * 
	 * @return
	 */
	public String pesquisar() {
		livros = service.pesquisar(nome, editora);
		LOG.info("livros.size: " + livros.size());
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public String processar() {
		for (Livro selecionado : selecionados) {
			LOG.info("Selecionado: " + selecionado.getId());
		}
		
		/*
		 * Simulando alguma regra de negócio que por um acaso
		 * marca os objetos (livros) 55 e 56.
		 */
		Livro livro15 = new Livro();
		Livro livro16 = new Livro();
		livro15.setId(15L);
		livro16.setId(16L);
		selecionados.add(livro15);
		selecionados.add(livro16);
		
		return null;
	}
	
	public void onToggleSelect(ToggleSelectEvent event) {
		LOG.info("evento disparado");
	}

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
	 * @return the editora
	 */
	public String getEditora() {
		return editora;
	}

	/**
	 * @param editora the editora to set
	 */
	public void setEditora(String editora) {
		this.editora = editora;
	}

	/**
	 * @return the livros
	 */
	public List<Livro> getLivros() {
		return livros;
	}

	/**
	 * @param livros the livros to set
	 */
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	/**
	 * @return the selecionados
	 */
	public List<Livro> getSelecionados() {
		return selecionados;
	}

	/**
	 * @param selecionados the selecionados to set
	 */
	public void setSelecionados(List<Livro> selecionados) {
		this.selecionados = selecionados;
	}
}
