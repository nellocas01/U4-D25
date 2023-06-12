package com.example.u4d25.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.u4d25.entities.Prenotazione;
import com.example.u4d25.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioniController {
	@Autowired
	private PrenotazioneService prenotazioneService;

	@GetMapping("")
	public Page<Prenotazione> getPrenotazione(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return prenotazioneService.find(page, size, sortBy);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Prenotazione savePrenotazione(@RequestBody Prenotazione body) {

		return prenotazioneService.create(body);
	}

	@GetMapping("/{prenotazioneId}")
	public Prenotazione getPrenotazione(@PathVariable UUID prenotazioneId) throws Exception {

		return prenotazioneService.findById(prenotazioneId);
	}

	@PutMapping("/{prenotazioneId}")
	public Prenotazione updatePrenotazione(@PathVariable UUID prenotazioneId, @RequestBody Prenotazione body)
			throws Exception {
		return prenotazioneService.findByIdAndUpdate(prenotazioneId, body);
	}

	@DeleteMapping("/{prenotazioneId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePrenotazione(@PathVariable UUID prenotazioneId) throws Exception {

		prenotazioneService.findByIdAndDelete(prenotazioneId);
	}

}