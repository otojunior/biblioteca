/**
 * 
 */
package org.otojunior.biblioteca.service.init;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.otojunior.biblioteca.entidade.usuario.Genero;
import org.otojunior.biblioteca.entidade.usuario.Usuario;
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
	
	@EJB
	private UsuarioService service;
	
	/**
	 * 
	 */
	public InitService() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		Usuario u1 = new Usuario();
		u1.setNome("teste");
		u1.setDataNascimento(LocalDate.of(1980, 12, 25));
		u1.setGenero(Genero.MASCULINO);
		
		Usuario u2 = new Usuario();
		u2.setNome("teste2");
		u2.setDataNascimento(LocalDate.of(1982, 01, 01));
		u2.setGenero(Genero.FEMININO);
		
		service.persistir(u1);
		service.persistir(u2);
		
		LOG.info("");
	}
}
