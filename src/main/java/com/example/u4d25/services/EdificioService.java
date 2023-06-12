package com.example.u4d25.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.u4d25.entities.Edificio;
import com.example.u4d25.repository.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository edificioRepo;

	public Edificio create(Edificio e) {
		return edificioRepo.save(e);
	}

	public List<Edificio> find() {
		return edificioRepo.findAll();
	}

	public Edificio findById(UUID id) throws Exception {
		return edificioRepo.findById(id).orElseThrow(() -> new Exception("edificio non trovato"));
	}

	public Edificio findByIdAndUpdate(UUID id, Edificio u) throws Exception {
		Edificio found = this.findById(id);

		found.setId(id);
		found.setIndirizzo(u.getIndirizzo());
		found.setName(u.getName());
		found.setCitta(u.getCitta());

		return edificioRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws Exception {
		Edificio found = this.findById(id);

		edificioRepo.delete(found);
	}
}