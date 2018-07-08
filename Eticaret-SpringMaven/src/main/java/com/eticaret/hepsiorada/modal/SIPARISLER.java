package com.eticaret.hepsiorada.modal;

import static javax.persistence.LockModeType.READ;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: SIPARISLER
 *
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "Siparisler.findAll", query = "select sip from SIPARISLER sip"), 
	@NamedQuery(name = "Siparisler.findById", query = "select sip from SIPARISLER sip where sip.ID =:SIPID", lockMode = READ) 
})
@Where(clause="DELETED=false and ACTIVE=true")
public class SIPARISLER extends BaseEntity implements Serializable {

	private String SIPARISCODE;

	@OneToOne
	private ADRES ADRES;

	private static final long serialVersionUID = 1L;

	public SIPARISLER() {
		super();
	}

	public String getSIPARISCODE() {
		return this.SIPARISCODE;
	}

	public void setSIPARISCODE(String SIPARISCODE) {
		this.SIPARISCODE = SIPARISCODE;
	}

	public ADRES getADRES() {
		return ADRES;
	}

	public void setADRES(ADRES aDRES) {
		ADRES = aDRES;
	}

}
