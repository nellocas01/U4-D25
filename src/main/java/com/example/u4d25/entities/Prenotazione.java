package com.example.u4d25.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenotazioni")
@Data
@NoArgsConstructor
public class Prenotazione {
	@Id
	@GeneratedValue
	private UUID id;
	@ManyToOne
	private Utente idUtente;
	@ManyToOne
	private Postazione idPostazione;
	private Date data;

	public Prenotazione(Utente idUtente, Postazione idPostazione, Date data) {
		super();
		this.idUtente = idUtente;
		this.idPostazione = idPostazione;
		this.data = data;
	}

}
