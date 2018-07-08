package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.LockModeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: Adres
 *
 */
@Entity

@NamedQueries({ 
	@NamedQuery(name = "Adres.findAll", query = "lockMode = LockModeType.READ"), 
	@NamedQuery(name = "AdresfindById", query = "select a from ADRES a WHERE a.ID =:AID") 
})

@Where(clause= "DELETE=false")
public class ADRES extends BaseEntitiy implements Serializable {

	
	@Column(length = 500)
	private String ACIK_ADRES;
	private static final long serialVersionUID = 1L;

	public ADRES() {
		super();
	}   
	public String getACIK_ADRES() {
		return this.ACIK_ADRES;
	}

	public void setACIK_ADRES(String ACIK_ADRES) {
		this.ACIK_ADRES = ACIK_ADRES;
	}
   
}
