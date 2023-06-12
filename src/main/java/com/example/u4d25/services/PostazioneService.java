package com.example.u4d25.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.u4d25.entities.Postazione;
import com.example.u4d25.repository.PostazioneRepository;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneRepository postazioneRepo;

	public Postazione create(Postazione e) {
		return postazioneRepo.save(e);
	}

	public List<Postazione> find() {
		return postazioneRepo.findAll();
	}

	public Postazione findById(UUID id) throws Exception {
		return postazioneRepo.findById(id).orElseThrow(() -> new Exception("Postazione non trovato"));
	}

	public Postazione findByIdAndUpdate(UUID id, Postazione u) throws Exception {
		Postazione found = this.findById(id);

		found.setId(id);
		found.setDescrizione(u.getDescrizione());
		found.setTipo(u.getTipo());
		found.setPrenotazioni(u.getPrenotazioni());

		return postazioneRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws Exception {
		Postazione found = this.findById(id);

		postazioneRepo.delete(found);
	}
}