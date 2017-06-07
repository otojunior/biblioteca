/**
 * 
 */
package org.otojunior.biblioteca.livro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.apache.commons.collections4.CollectionUtils;
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
	private boolean todosSelecionados = false;
	
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
		 * marca os dois primeiros registros
		 */
		Livro livroA = new Livro();
		Livro livroB = new Livro();
		livroA.setId(livros.get(0).getId());
		livroB.setId(livros.get(1).getId());
		selecionados.add(livroA);
		selecionados.add(livroB);
		
		return null;
	}
	
	/**
	 * 
	 * @param event
	 */
	public void onToggleSelect(ToggleSelectEvent event) {
		if (todosSelecionados) {
			selecionados = Collections.emptyList();
			todosSelecionados = false;
		} else {
			selecionados = new ArrayList<>(livros);
			todosSelecionados = true;
		}
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
