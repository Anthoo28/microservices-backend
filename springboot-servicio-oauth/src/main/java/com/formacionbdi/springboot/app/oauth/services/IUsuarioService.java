package com.formacionbdi.springboot.app.oauth.services;


import com.formacionbdi.springboot.app.oauth.Model.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);
	
	public Usuario update(Usuario usuario, Long id);

}
