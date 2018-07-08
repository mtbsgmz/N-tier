package com.eticaret.hepsiorada.modal;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.LockModeType.READ;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: Adres
 *
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "Adres.findAll", query = "select a from ADRES a", lockMode = READ), 
	@NamedQuery(name = "Adres.findById", query = "select a from ADRES a WHERE a.ID =:AID") 
})
@Where(clause="DELETED=false and ACTIVE=true")
public class ADRES extends BaseEntity implements Serializable {

	
	@Enumerated(STRING)
	private NITELIK ADRESNITELIK;
	private String ACIKADRES;

	@ManyToOne
	@JoinColumn(name = "KULLANICI_ID", referencedColumnName = "ID")
	private KULLANICI KULLANICI;

	private static final long serialVersionUID = 1L;

	public ADRES() {
		super();
	}

	public KULLANICI getKULLANICI() {
		return KULLANICI;
	}

	public void setKULLANICI(KULLANICI kULLANICI) {
		KULLANICI = kULLANICI;
	}

	public NITELIK getADRESNITELIK() {
		return ADRESNITELIK;
	}

	public void setADRESNITELIK(NITELIK aDRESNITELIK) {
		ADRESNITELIK = aDRESNITELIK;
	}

	public String getACIKADRES() {
		return this.ACIKADRES;
	}

	public void setACIKADRES(String ACIKADRES) {
		this.ACIKADRES = ACIKADRES;
	}

}
