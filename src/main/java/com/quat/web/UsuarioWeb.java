package com.quat.web;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.Credencial;
import com.quat.model.Perfil;
import com.quat.model.Usuario;
import com.quat.service.CredencialService;
import com.quat.service.PerfilService;
import com.quat.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioWeb {

	@Autowired
	UsuarioService entityService;

	@Autowired
	PerfilService perfilService;

	@Autowired
	CredencialService credencialService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Usuario create(@ModelAttribute Usuario entity, @RequestParam String correo, @RequestParam String contraseña) throws Exception {
		Credencial credencial = new Credencial();

		credencial.setId(0);
		credencial.setCorreo(correo);
		credencial.setContraseña(contraseña);
		
		credencial = credencialService.create(credencial);

		entity.setCredencial(credencial);

		entity.setActivo(true);

		return entityService.create(entity);
	}

	@GetMapping("/remove/perfil")
	public Usuario removePerfil(@RequestParam Integer id_usuario, @RequestParam String perfil) throws Exception {
		Optional<Usuario> uOptional = entityService.getWithId(id_usuario);
		if (!uOptional.isPresent()) {
			return null;
		}
		Optional<Perfil> pOptional = perfilService.getWithNombre(perfil);
		if (!pOptional.isPresent()) {
			return null;
		}
		Perfil perfil_ = pOptional.get();
		Usuario usuario = uOptional.get();
		Set<Perfil> perfiles = usuario.getPerfiles();
		perfiles.remove(perfil_);
		usuario.setPerfiles(perfiles);
		entityService.update(usuario);
		return usuario;
	}

	@GetMapping("/add/perfil")
	public Usuario addPerfil(@RequestParam Integer id_usuario, @RequestParam String perfil) throws Exception {
		Optional<Usuario> uOptional = entityService.getWithId(id_usuario);
		if (!uOptional.isPresent()) {
			return null;
		}
		Optional<Perfil> pOptional = perfilService.getWithNombre(perfil);
		if (!pOptional.isPresent()) {
			return null;
		}
		Perfil perfil_ = pOptional.get();
		Usuario usuario = uOptional.get();
		Set<Perfil> perfiles = usuario.getPerfiles();
		if (perfiles == null) {
			perfiles = new HashSet<>();
		}
		perfiles.add(perfil_);
		usuario.setPerfiles(perfiles);
		entityService.update(usuario);
		return usuario;
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Usuario> getAll() {
		return entityService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Usuario> getWithId(@RequestParam Integer id) {
		return entityService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Usuario update(@RequestParam Integer id, @RequestParam String correo, @RequestParam String contraseña) throws Exception {
		Optional<Usuario> uOptional = entityService.getWithId(id);

		if (!uOptional.isPresent()) {
			throw new Exception("El usuario no es válido");
		}

		Usuario usuario = uOptional.get();

		Credencial credencial = usuario.getCredencial();

		credencial.setCorreo(correo);
		credencial.setContraseña(contraseña);

		usuario.setCredencial(credencial);

		return entityService.update(usuario);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Usuario delete(@ModelAttribute Usuario entity) throws Exception {
		return entityService.delete(entity);
	}
	
}
