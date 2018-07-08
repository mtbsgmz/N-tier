package com.eticaret.hepsiorada.modal;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.LockModeType.READ;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: URUN
 *
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "Urun.findAll", query = "SELECT u from URUN u"), 
	@NamedQuery(name = "Urun.findById", query = "select u from URUN u where u.ID=:UID", lockMode = READ) 
})
@Where(clause="DELETED=false and ACTIVE=true")
public class URUN extends BaseEntity implements Serializable {

	@Column(nullable = false)
	private String AD;

	@Column(nullable = false)
	private Integer STOK;

	@Column(nullable = false)
	private Float FIYAT;

	@Column(nullable = false)
	private String BARKOD;

	@Column(nullable = false)
	private String RESIMICON;

	@OneToMany(cascade = ALL)
	private List<URUNRESIMLERI> URUNRESIMLERI;

	@OneToMany(cascade = ALL)
	private List<YORUM> YORUMLAR;

	private static final long serialVersionUID = 1L;

	public URUN() {
		super();
	}

	public List<URUNRESIMLERI> getURUNRESIMLERI() {
		return URUNRESIMLERI;
	}

	public void setURUNRESIMLERI(List<URUNRESIMLERI> uRUNRESIMLERI) {
		URUNRESIMLERI = uRUNRESIMLERI;
	}

	public List<YORUM> getYORUMLAR() {
		return YORUMLAR;
	}

	public void setYORUMLAR(List<YORUM> yORUMLAR) {
		YORUMLAR = yORUMLAR;
	}

	public String getAD() {
		return this.AD;
	}

	public void setAD(String AD) {
		this.AD = AD;
	}

	public Integer getSTOK() {
		return this.STOK;
	}

	public void setSTOK(Integer STOK) {
		this.STOK = STOK;
	}

	public Float getFIYAT() {
		return this.FIYAT;
	}

	public void setFIYAT(Float FIYAT) {
		this.FIYAT = FIYAT;
	}

	public String getBARKOD() {
		return this.BARKOD;
	}

	public void setBARKOD(String BARKOD) {
		this.BARKOD = BARKOD;
	}

	public String getRESIMICON() {
		return this.RESIMICON;
	}

	public void setRESIMICON(String RESIMICON) {
		this.RESIMICON = RESIMICON;
	}

}
