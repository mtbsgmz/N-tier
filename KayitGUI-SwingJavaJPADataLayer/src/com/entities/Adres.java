package com.entities;

import com.entities.BaseEntitiy;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Adres
 *
 */
@Entity

public class Adres extends BaseEntitiy implements Serializable {

	
	@Column(length = 500)
	private String ACIK_ADRES;
	private static final long serialVersionUID = 1L;

	public Adres() {
		super();
	}   
	public String getACIK_ADRES() {
		return this.ACIK_ADRES;
	}

	public void setACIK_ADRES(String ACIK_ADRES) {
		this.ACIK_ADRES = ACIK_ADRES;
	}
   
}
