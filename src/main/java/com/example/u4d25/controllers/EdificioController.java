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

import com.example.u4d25.entities.Edificio;
import com.example.u4d25.services.EdificioService;

@RestController
@RequestMapping("/edificio")
public class EdificioController {
	@Autowired
	private EdificioService edificioService;

	@GetMapping("")
	public List<Edificio> getEdificio() {
		return edificioService.find();
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Edificio saveEdificio(@RequestBody Edificio body) {

		return edificioService.create(body);
	}

	@GetMapping("/{edificioId}")
	public Edificio getEdificio(@PathVariable UUID edificioId) throws Exception {

		return edificioService.findById(edificioId);
	}

	@PutMapping("/{edificioId}")
	public Edificio updateEdificio(@PathVariable UUID edificioId, @RequestBody Edificio body) throws Exception {
		return edificioService.findByIdAndUpdate(edificioId, body);
	}

	@DeleteMapping("/{edificioId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEdificio(@PathVariable UUID edificioId) throws Exception {

		edificioService.findByIdAndDelete(edificioId);
	}

}
