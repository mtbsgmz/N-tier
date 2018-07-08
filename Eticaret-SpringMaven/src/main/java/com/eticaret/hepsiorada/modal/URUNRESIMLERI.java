package com.eticaret.hepsiorada.modal;

import static javax.persistence.LockModeType.READ;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: URUNRESIMLERI
 *
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "Urunresimleri.findAll", query = "select ure from URUNRESIMLERI ure"), 
	@NamedQuery(name = "Urunresimleri.findById", query = "select ure from URUNRESIMLERI ure  where ure.ID =:UREID", lockMode = READ) 
})
@Where(clause="DELETED=false and ACTIVE=true")
public class URUNRESIMLERI extends BaseEntity implements Serializable {

	private String RESIMAD;

	@ManyToOne
	@JoinColumn(name = "URUN_ID", referencedColumnName = "ID")
	private URUN URUN;

	private static final long serialVersionUID = 1L;

	public URUNRESIMLERI() {
		super();
	}

	public String getRESIMAD() {
		return this.RESIMAD;
	}

	public void setRESIMAD(String RESIMAD) {
		this.RESIMAD = RESIMAD;
	}

	public URUN getURUN() {
		return URUN;
	}

	public void setURUN(URUN uRUN) {
		URUN = uRUN;
	}

}
