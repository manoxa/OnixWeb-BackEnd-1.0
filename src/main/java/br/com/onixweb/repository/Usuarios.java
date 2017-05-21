package br.com.onixweb.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import br.com.onixweb.model.Usuario;


public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario porId(Long id) {
		return this.manager.find(Usuario.class, id);
	}
	
	public List<Usuario> vendedores() {
		return this.manager.createQuery("from Usuario", Usuario.class)
				.getResultList();
	}

	public Usuario porUsuario(String username) {
		Usuario usuario = null;
		
		try {
			usuario = this.manager.createQuery("from Usuario u where lower(u.usuario) = :username", Usuario.class)
				.setParameter("username", username.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			
		}
		
		return usuario;
	}
	
}