package com.example.u4d25.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.u4d25.entities.Utente;
import com.example.u4d25.services.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
	@Autowired
	private UtenteService utenteService;

	@GetMapping("")
	public List<Utente> getUtenti() {
		return utenteService.find();
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUtente(@RequestBody Utente body) {

		return utenteService.create(body);
	}

	@GetMapping("/{utentiId}")
	public Utente getUtente(@PathVariable UUID utenteId) throws Exception {

		return utenteService.findById(utenteId);
	}

	@PutMapping("/{utentiId}")
	public Utente updateUtente(@PathVariable UUID utenteId, @RequestBody Utente body) throws Exception {

		return utenteService.findByIdAndUpdate(utenteId, body);
	}

	@DeleteMapping("/{utentiId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUtente(@PathVariable UUID utenteId) throws Exception {

		utenteService.findByIdAndDelete(utenteId);
	}

}
