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
import com.quat.model.Personal;
import com.quat.model.Usuario;
import com.quat.service.CredencialService;
import com.quat.service.PerfilService;
import com.quat.service.PersonalService;
import com.quat.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioWeb {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	PerfilService perfilService;

	@Autowired
	CredencialService credencialService;

	@Autowired
	PersonalService personalService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Usuario create(@RequestParam String correo, @RequestParam String contraseña, 
		@RequestParam Integer max_intentos, @RequestParam Integer personal_id) throws Exception {
		return usuarioService.create(correo, contraseña, max_intentos, personal_id);
	}

	@GetMapping("/remove/perfil")
	public Usuario removePerfil(@RequestParam Integer id_usuario, 
		@RequestParam Integer perfil_id) throws Exception {
		Optional<Usuario> uOptional = usuarioService.getWithId(id_usuario);
		if (!uOptional.isPresent()) {
			return null;
		}
		Optional<Perfil> pOptional = perfilService.getWithId(perfil_id);
		if (!pOptional.isPresent()) {
			return null;
		}
		Perfil perfil_ = pOptional.get();
		Usuario usuario = uOptional.get();
		Set<Perfil> perfiles = usuario.getPerfiles();
		perfiles.remove(perfil_);
		usuario.setPerfiles(perfiles);
		usuarioService.update(usuario);
		return usuario;
	}

	@GetMapping("/add/perfil")
	public Usuario addPerfil(@RequestParam Integer id_usuario,
		@RequestParam Integer perfil_id) throws Exception {
		Optional<Usuario> uOptional = usuarioService.getWithId(id_usuario);
		if (!uOptional.isPresent()) {
			return null;
		}
		Optional<Perfil> pOptional = perfilService.getWithId(perfil_id);
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
		usuarioService.update(usuario);
		return usuario;
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Usuario> getAll() {
		return usuarioService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Usuario> getWithId(@RequestParam Integer id) {
		return usuarioService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Usuario update(@RequestParam Integer id,
		@RequestParam String correo, @RequestParam String contraseña,
		@RequestParam Integer max_intentos, @RequestParam Integer intentos,
		@RequestParam Integer personal_id) throws Exception {
		return usuarioService.update(id, correo, contraseña, 
			max_intentos, intentos, personal_id);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Usuario delete(@ModelAttribute Usuario entity) throws Exception {
		return usuarioService.delete(entity);
	}
	
}
