package com.formacionbdi.springboot.app.oauth.clients;

import com.formacionbdi.springboot.app.oauth.Model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="servicio-usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByUsername(@RequestParam String username);
	
	@PutMapping("/usuarios/{dni}")
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long dni);
}
