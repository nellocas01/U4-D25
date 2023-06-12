package com.example.u4d25.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.u4d25.entities.Utente;
import com.example.u4d25.exceptions.NotFoundException;
import com.example.u4d25.repository.UtenteRepository;

@Service
public class UtenteService {
	@Autowired
	private UtenteRepository utenteRepo;

	public Utente create(Utente u) {
		return utenteRepo.save(u);
	}

	public List<Utente> find() {
		return utenteRepo.findAll();
	}

	public Utente findById(UUID id) throws Exception {
		return utenteRepo.findById(id).orElseThrow(() -> new Exception("utente non trovato"));
	}

	public Utente findByEmail(String email) throws NotFoundException {
		return utenteRepo.findByEmail(email).orElseThrow(() -> new NotFoundException("utente non trovato"));
	}

	public Utente findByIdAndUpdate(UUID id, Utente u) throws Exception {
		Utente found = this.findById(id);

		found.setId(id);
		found.setName(u.getName());
		found.setSurname(u.getSurname());
		found.setEmail(u.getEmail());
		found.setUtenti(u.getUtenti());

		return utenteRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws Exception {
		Utente found = this.findById(id);

		utenteRepo.delete(found);
	}
}
