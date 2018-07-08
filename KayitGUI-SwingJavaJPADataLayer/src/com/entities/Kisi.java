package com.entities;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * Entity implementation class for Entity: Kisi
 *
 */
@Entity

public class Kisi extends BaseEntitiy implements Serializable {

	
	private String AD;
	@Enumerated(STRING)
	private CINSIYET cinsiyet;
	
	@Temporal(TIMESTAMP)
	private Calendar CREATED_TIME;
	
	@OneToOne(cascade = ALL)
	private ADRES adres;
	
	@OneToMany(cascade = ALL)
	private List<Arac> araclar;
	private static final long serialVersionUID = 1L;

	public Kisi() {
		super();
	}   
	public String getAD() {
		return this.AD;
	}

	public void setAD(String AD) {
		this.AD = AD;
	}
	public ADRES getAdres() {
		return adres;
	}
	public void setAdres(ADRES adres) {
		this.adres = adres;
	}
	public CINSIYET getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(CINSIYET cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public List<Arac> getAraclar() {
		return araclar;
	}
	public void setAraclar(List<Arac> araclar) {
		this.araclar = araclar;
	}
	public Calendar getCREATED_TIME() {
		return CREATED_TIME;
	}
	public void setCREATED_TIME(Calendar cREATED_TIME) {
		CREATED_TIME = cREATED_TIME;
	}
	
	   
}
