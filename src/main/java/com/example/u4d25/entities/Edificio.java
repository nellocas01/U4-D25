package com.example.u4d25.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "edificio")
@Data
@NoArgsConstructor
public class Edificio {
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String indirizzo;
	private String citta;

	public Edificio(String name, String indirizzo, String citta) {
		super();
		this.name = name;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}
}