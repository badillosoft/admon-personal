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

import com.quat.model.Perfil;
import com.quat.model.Rol;
import com.quat.service.PerfilService;
import com.quat.service.RolService;

@RestController
@RequestMapping("/api/perfil")
public class PerfilWeb {

	@Autowired
	PerfilService entityService;

	@Autowired
	RolService rolService;
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Perfil create(@ModelAttribute Perfil entity) throws Exception {
		return entityService.create(entity);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Perfil> getAll() {
		return entityService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Perfil> getWithId(@RequestParam Integer id) {
		return entityService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Perfil update(@ModelAttribute Perfil entity) throws Exception {
		return entityService.update(entity);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Perfil delete(@ModelAttribute Perfil entity) throws Exception {
		return entityService.delete(entity);
	}

	@GetMapping("/remove/rol")
	public Perfil removeRol(@RequestParam Integer id_perfil, @RequestParam String rol) throws Exception {
		Optional<Perfil> pOptional = entityService.getWithId(id_perfil);
		if (!pOptional.isPresent()) {
			return null;
		}
		Optional<Rol> rOptional = rolService.getWithNombre(rol);
		if (!rOptional.isPresent()) {
			return null;
		}
		Rol rol_ = rOptional.get();
		Perfil perfil = pOptional.get();
		Set<Rol> roles = perfil.getRoles();
		roles.remove(rol_);
		perfil.setRoles(roles);
		entityService.update(perfil);
		return perfil;
	}

	@GetMapping("/add/rol")
	public Perfil addRol(@RequestParam Integer id_perfil, @RequestParam String rol) throws Exception {
		Optional<Perfil> pOptional = entityService.getWithId(id_perfil);
		if (!pOptional.isPresent()) {
			return null;
		}
		Optional<Rol> rOptional = rolService.getWithNombre(rol);
		if (!rOptional.isPresent()) {
			return null;
		}
		Rol rol_ = rOptional.get();
		Perfil perfil = pOptional.get();
		Set<Rol> roles = perfil.getRoles();
		if (roles == null) {
			roles = new HashSet<>();
		}
		roles.add(rol_);
		perfil.setRoles(roles);
		entityService.update(perfil);
		return perfil;
	}
	
}
