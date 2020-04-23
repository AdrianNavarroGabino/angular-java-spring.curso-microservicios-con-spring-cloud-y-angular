package com.adriannavarrogabino.microservicios.examenes.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "preguntas")
public class Pregunta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String texto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "examen_id")
	@JsonIgnoreProperties(value = { "preguntas" })
	private Examen examen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Pregunta)) {
			return false;
		}
		
		Pregunta a = (Pregunta) obj;
		
		return this.id != null && this.id.equals(a.getId());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
