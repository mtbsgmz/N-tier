package com.data.entities;

import com.data.entities.BaseEntity;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Departman
 *
 */
@Entity
@Table(name = "Departman")
public class Departman extends BaseEntity implements Serializable {

	@Column(nullable = false, unique = true)
	private String DepAd;

	@Column(length = 500, nullable = false)
	private String Aciklama;
	private static final long serialVersionUID = 1L;

	public Departman() {
		super();
	}

	public String getDepAd() {
		return this.DepAd;
	}

	public void setDepAd(String DepAd) {
		this.DepAd = DepAd;
	}

	public String getAciklama() {
		return this.Aciklama;
	}

	public void setAciklama(String Aciklama) {
		this.Aciklama = Aciklama;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Aciklama == null) ? 0 : Aciklama.hashCode());
		result = prime * result + ((DepAd == null) ? 0 : DepAd.hashCode());
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
		Departman other = (Departman) obj;
		if (Aciklama == null) {
			if (other.Aciklama != null)
				return false;
		} else if (!Aciklama.equals(other.Aciklama))
			return false;
		if (DepAd == null) {
			if (other.DepAd != null)
				return false;
		} else if (!DepAd.equals(other.DepAd))
			return false;
		return true;
	}

}
