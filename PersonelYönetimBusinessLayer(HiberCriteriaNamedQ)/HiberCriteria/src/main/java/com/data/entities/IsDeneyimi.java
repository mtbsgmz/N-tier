package com.data.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: IsDeneyimi
 *
 */
@Entity
public class IsDeneyimi extends BaseEntity implements Serializable {

	
	   
	private String FIRMAADI;
	
	@Temporal(TemporalType.DATE)
	private Calendar ISEGIRIS;

	@Temporal(TemporalType.DATE)
	private Calendar ISTENCIKIS;
	
	private String UNVAN;
	private static final long serialVersionUID = 1L;

	public IsDeneyimi() {
		super();
	}   

	public String getFIRMAADI() {
		return this.FIRMAADI;
	}

	public void setFIRMAADI(String FIRMAADI) {
		this.FIRMAADI = FIRMAADI;
	}   
	public Calendar getISEGIRIS() {
		return this.ISEGIRIS;
	}

	public void setISEGIRIS(Calendar ISEGIRIS) {
		this.ISEGIRIS = ISEGIRIS;
	}   
	public Calendar getISTENCIKIS() {
		return this.ISTENCIKIS;
	}

	public void setISTENCIKIS(Calendar ISTENCIKIS) {
		this.ISTENCIKIS = ISTENCIKIS;
	}   
	public String getUNVAN() {
		return this.UNVAN;
	}

	public void setUNVAN(String UNVAN) {
		this.UNVAN = UNVAN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((FIRMAADI == null) ? 0 : FIRMAADI.hashCode());
		result = prime * result + ((ISEGIRIS == null) ? 0 : ISEGIRIS.hashCode());
		result = prime * result + ((ISTENCIKIS == null) ? 0 : ISTENCIKIS.hashCode());
		result = prime * result + ((UNVAN == null) ? 0 : UNVAN.hashCode());
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
		IsDeneyimi other = (IsDeneyimi) obj;
		if (FIRMAADI == null) {
			if (other.FIRMAADI != null)
				return false;
		} else if (!FIRMAADI.equals(other.FIRMAADI))
			return false;
		if (ISEGIRIS == null) {
			if (other.ISEGIRIS != null)
				return false;
		} else if (!ISEGIRIS.equals(other.ISEGIRIS))
			return false;
		if (ISTENCIKIS == null) {
			if (other.ISTENCIKIS != null)
				return false;
		} else if (!ISTENCIKIS.equals(other.ISTENCIKIS))
			return false;
		if (UNVAN == null) {
			if (other.UNVAN != null)
				return false;
		} else if (!UNVAN.equals(other.UNVAN))
			return false;
		return true;
	}
   
	
	
}
