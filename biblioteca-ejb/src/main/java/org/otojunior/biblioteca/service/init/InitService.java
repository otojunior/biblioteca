/**
 * 
 */
package org.otojunior.biblioteca.service.init;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.otojunior.biblioteca.entidade.usuario.Usuario;
import org.otojunior.biblioteca.entidade.usuario.mock.UsuarioFabrica;
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
		for (int i = 0; i < 100; i++) {
			Usuario u = UsuarioFabrica.criar();
			LOG.info(u.toString());
			service.persistir(u);
		}
	}
}
