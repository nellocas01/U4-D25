package com.example.u4d25.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.u4d25.entities.Prenotazione;
import com.example.u4d25.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepo;

	public Prenotazione create(Prenotazione e) {
		return prenotazioneRepo.save(e);
	}

	public Page<Prenotazione> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return prenotazioneRepo.findAll(pageable);
	}

	public Prenotazione findById(UUID id) throws Exception {
		return prenotazioneRepo.findById(id).orElseThrow(() -> new Exception("Prenotazione non trovato"));
	}

	public Prenotazione findByIdAndUpdate(UUID id, Prenotazione u) throws Exception {
		Prenotazione found = this.findById(id);

		found.setId(id);
		found.setData(u.getData());
		found.setIdPostazione(u.getIdPostazione());
		found.setIdUtente(u.getIdUtente());

		return prenotazioneRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws Exception {
		Prenotazione found = this.findById(id);

		prenotazioneRepo.delete(found);
	}
}