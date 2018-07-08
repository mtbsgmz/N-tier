package com.data.entities;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.DETACH;

/**
 * Entity implementation class for Entity: Kisi
 *
 */
@Entity
@Table(name = "MYUSER")
@NamedQueries({ @NamedQuery(name = "Kisi.findAll", query = "select k from Kisi k where k.deleted=false"),
		@NamedQuery(name = "Kisi.findById", query = "select k from Kisi k where k.ID = :kisipar"),
		@NamedQuery(name = "Kisi.deleteById", query = "delete from Kisi k where k.ID = :kisiid") })
public class Kisi extends BaseEntity implements Serializable {

	private String AD;
	private String SOYAD;
	private String TC;

	@OneToOne(cascade = ALL, fetch=FetchType.LAZY)
	private KritikHastalik kritikHastalik;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Adres> adres;

	
	@JoinTable(joinColumns = 
			@JoinColumn(name = "Kisi_ID", 
			referencedColumnName = "ID"), 
			inverseJoinColumns = 
			@JoinColumn(name = "departmanlar_ID", 
			referencedColumnName = "ID"))
	@OneToMany(cascade = { PERSIST, MERGE, REFRESH, DETACH })
	private Set<Departman> departmanlar;
	
	
	@OneToMany(cascade = ALL)
	private List<IsDeneyimi> isDeneyimleri;

	@Column(nullable = false, length = 500)
	private String ADRES;// NVARCHAR2

	@Temporal(DATE)
	@Column(nullable = true)
	private Calendar DTARIHI;

	@Transient
	private String ADSOYAD;

	@Enumerated(STRING)
	private CINSIYET cinsiyet;

	@Enumerated(STRING)
	private EGITIM egitim;

	private Boolean silindi = false;

	
	
	public Set<Departman> getDepartmanlar() {
		return departmanlar;
	}

	public void setDepartmanlar(Set<Departman> departmanlar) {
		this.departmanlar = departmanlar;
	}

	public KritikHastalik getKritikHastalik() {
		return kritikHastalik;
	}

	public void setKritikHastalik(KritikHastalik kritikHastalik) {
		this.kritikHastalik = kritikHastalik;
	}

	public List<Adres> getAdres() {
		return adres;
	}

	public void setAdres(List<Adres> adres) {
		this.adres = adres;
	}

	public List<IsDeneyimi> getIsDeneyimleri() {
		return isDeneyimleri;
	}

	public void setIsDeneyimleri(List<IsDeneyimi> isDeneyimleri) {
		this.isDeneyimleri = isDeneyimleri;
	}

	public Boolean getSilindi() {
		return silindi;
	}

	public void setSilindi(Boolean silindi) {
		this.silindi = silindi;
	}

	public EGITIM getEgitim() {
		return egitim;
	}

	public void setEgitim(EGITIM egitim) {
		this.egitim = egitim;
	}

	public CINSIYET getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(CINSIYET cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	@PostConstruct
	private void init() {

	}

	@PostLoad
	private void initialSetter() {
		setADSOYAD(getAD() + " - " + getSOYAD());
	}

	@PrePersist
	private void kaydetmedenOnce() {

	}

	@PostPersist
	private void kaydettiktenSonra() {

	}

	@PreRemove
	private void silmedenOnce() {

	}

	@PostRemove
	private void sildiktenSonra() {

	}

	@PreUpdate
	private void guncellemedenOnce() {

	}

	@PostUpdate
	private void guncellediktenSonra() {

	}

	public String getADSOYAD() {
		return ADSOYAD;
	}

	public void setADSOYAD(String aDSOYAD) {
		ADSOYAD = aDSOYAD;
	}

	public Calendar getDTARIHI() {
		return DTARIHI;
	}

	public void setDTARIHI(Calendar dTARIHI) {
		DTARIHI = dTARIHI;
	}

	public String getADRES() {
		return ADRES;
	}

	public void setADRES(String aDRES) {
		ADRES = aDRES;
	}

	private static final long serialVersionUID = 1L;

	public Kisi() {

	}

	public String getAD() {
		return this.AD;
	}

	public void setAD(String AD) {
		this.AD = AD;
	}

	public String getSOYAD() {
		return this.SOYAD;
	}

	public void setSOYAD(String SOYAD) {
		this.SOYAD = SOYAD;
	}

	public String getTC() {
		return this.TC;
	}

	public void setTC(String TC) {
		this.TC = TC;
	}

	@Override
	public String toString() {
		return "Kisi [KISI_ID=" + getID() + ", AD=" + AD + ", SOYAD=" + SOYAD + ", TC=" + TC + ", ADRES=" + ADRES
				+ ", DTARIHI=" + DTARIHI + ", ADSOYAD=" + ADSOYAD + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((AD == null) ? 0 : AD.hashCode());
		result = prime * result + ((ADRES == null) ? 0 : ADRES.hashCode());
		result = prime * result + ((ADSOYAD == null) ? 0 : ADSOYAD.hashCode());
		result = prime * result + ((DTARIHI == null) ? 0 : DTARIHI.hashCode());
		result = prime * result + ((SOYAD == null) ? 0 : SOYAD.hashCode());
		result = prime * result + ((TC == null) ? 0 : TC.hashCode());
		result = prime * result + ((cinsiyet == null) ? 0 : cinsiyet.hashCode());
		result = prime * result + ((egitim == null) ? 0 : egitim.hashCode());
		result = prime * result + ((silindi == null) ? 0 : silindi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kisi other = (Kisi) obj;
		if (AD == null) {
			if (other.AD != null)
				return false;
		} else if (!AD.equals(other.AD))
			return false;
		if (ADRES == null) {
			if (other.ADRES != null)
				return false;
		} else if (!ADRES.equals(other.ADRES))
			return false;
		if (ADSOYAD == null) {
			if (other.ADSOYAD != null)
				return false;
		} else if (!ADSOYAD.equals(other.ADSOYAD))
			return false;
		if (DTARIHI == null) {
			if (other.DTARIHI != null)
				return false;
		} else if (!DTARIHI.equals(other.DTARIHI))
			return false;
		if (SOYAD == null) {
			if (other.SOYAD != null)
				return false;
		} else if (!SOYAD.equals(other.SOYAD))
			return false;
		if (TC == null) {
			if (other.TC != null)
				return false;
		} else if (!TC.equals(other.TC))
			return false;
		if (cinsiyet != other.cinsiyet)
			return false;
		if (egitim != other.egitim)
			return false;
		if (silindi == null) {
			if (other.silindi != null)
				return false;
		} else if (!silindi.equals(other.silindi))
			return false;
		return true;
	}

}
