package com.data.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Adres
 *
 */
@Entity
@NamedQuery(name = "Adres.findAll", query = "select a from Adres a where a.deleted=false ")
public class Adres extends BaseEntity implements Serializable {

	@Column(length=500)
	private String ACIK_ADRES;
	
	@Enumerated(EnumType.STRING)
	private ADRESTIP adresType= ADRESTIP.valueOf("EV");
	
	private static final long serialVersionUID = 1L;

	public Adres() {
		super();
	}

	public ADRESTIP getAdresType() {
		return adresType;
	}


	public void setAdresType(ADRESTIP adresType) {
		this.adresType = adresType;
	}


	public String getACIK_ADRES() {
		return this.ACIK_ADRES;
	}

	public void setACIK_ADRES(String ACIK_ADRES) {
		this.ACIK_ADRES = ACIK_ADRES;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ACIK_ADRES == null) ? 0 : ACIK_ADRES.hashCode());
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
		Adres other = (Adres) obj;
		if (ACIK_ADRES == null) {
			if (other.ACIK_ADRES != null)
				return false;
		} else if (!ACIK_ADRES.equals(other.ACIK_ADRES))
			return false;
		return true;
	}

	
	
}
