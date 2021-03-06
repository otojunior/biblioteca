/**
 * 
 */
package org.otojunior.biblioteca.service.init;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.otojunior.biblioteca.entidade.livro.Livro;
import org.otojunior.biblioteca.entidade.mock.LivroFabrica;
import org.otojunior.biblioteca.entidade.mock.UsuarioFabrica;
import org.otojunior.biblioteca.entidade.usuario.Usuario;
import org.otojunior.biblioteca.service.livro.LivroService;
import org.otojunior.biblioteca.service.usuario.UsuarioService;
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
	
	@EJB private UsuarioService usuarioService;
	@EJB private LivroService livroService;
	
	/**
	 * 
	 */
	public InitService() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	@PostConstruct
	public void init() {
		final int N_USUARIOS = 48;
		final int N_LIVROS = 48;
		
		for (int i = 0; i < N_USUARIOS; i++) {
			Usuario u = UsuarioFabrica.criar();
			LOG.info(u.toString());
			usuarioService.persistir(u);
		}
		
		for (int i = 0; i < N_LIVROS; i++) {
			Livro lv = LivroFabrica.criar();
			LOG.info(lv.toString());
			livroService.persistir(lv);
		}
	}
}
