package com.quat.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.quat.model.Personal;
import com.quat.service.PersonalService;

@RestController
@RequestMapping("/api/personal")
public class PersonalWeb {

	@Autowired
	PersonalService personalService;
	
	@PostMapping("/photo")
	public Personal uploadPhoto(@ModelAttribute Personal personal, @RequestParam MultipartFile file) throws Exception {
		return personalService.uploadPhoto(personal, file);
	}
	
	// CRUD
	
	// CREATE
	@PostMapping("/create")
	public Personal create(@ModelAttribute Personal personal) throws Exception {
		return personalService.create(personal, null);
	}
	
	// READ
	@GetMapping("/all")
	public Iterable<Personal> getAll() {
		return personalService.getAll();
	}
	
	@GetMapping("/find")
	public Optional<Personal> getWithId(@RequestParam Integer id) {
		return personalService.getWithId(id);
	}
	
	// UPDATE
	@PostMapping("/update")
	public Personal update(@ModelAttribute Personal personal) throws Exception {
		return personalService.update(personal);
	}
	
	// DELETE
	@PostMapping("/delete")
	public Personal delete(@ModelAttribute Personal personal) throws Exception {
		return personalService.delete(personal);
	}
	
}
