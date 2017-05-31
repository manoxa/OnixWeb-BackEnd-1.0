package br.com.onixweb.security;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

@Named
@RequestScoped
public class Seguranca {

private String permissao;

/*	@Inject
	private ExternalContext externalContext;*/
	
	public String getNomeUsuario() {
		
		String nome = null;
		
		UsuarioSistema usuarioLogado = getUsuarioLogado();
		
		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNome();
		}
		
		return nome;
	}
	
	
	public String getPermissaoUsuario(){
		
		UsuarioSistema usuarioLogado = getUsuarioLogado();
		
		for(GrantedAuthority guAuthority : usuarioLogado.getAuthorities()){
			
			if("ROLE_ADIMINISTRADOR".equalsIgnoreCase(guAuthority.getAuthority())){
				this.permissao = guAuthority.getAuthority();
				System.out.println("Permissão    : " + permissao);
				
				return permissao;
				
			}else if("ROLE_MEMORIA_DE_CALCULO".equalsIgnoreCase(guAuthority.getAuthority())){
				this.permissao = guAuthority.getAuthority();
				System.out.println("Permissão    : " + permissao);
				
				return permissao;
				
			}else if("ROLE_UNIDADE_DE_MEDIDA".equalsIgnoreCase(guAuthority.getAuthority())){
				this.permissao = guAuthority.getAuthority();
				System.out.println("Permissão    : " + permissao);
				
				return permissao;	
				
			}else if("ROLE_FBO".equalsIgnoreCase(guAuthority.getAuthority())){
				this.permissao = guAuthority.getAuthority();
				System.out.println("Permissão    : " + permissao);
				
				return permissao;					
			}
		
		}
		
		return permissao;
	
	}

	@Produces
	@UsuarioLogado
	public UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) 
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if (auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuario;
	}
	
/*	public boolean isEmitirPedidoPermitido() {
		return externalContext.isUserInRole("ADMINISTRADORES") 
				|| externalContext.isUserInRole("VENDEDORES");
	}
	
	public boolean isCancelarPedidoPermitido() {
		return externalContext.isUserInRole("ADMINISTRADORES") 
				|| externalContext.isUserInRole("VENDEDORES");
	}*/
	
}
