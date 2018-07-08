package com.data.entities;

import com.data.entities.BaseEntity;
import java.io.Serializable;
import java.lang.String;
import java.util.Calendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: KritikHastalik
 *
 */
@Entity
public class KritikHastalik extends BaseEntity implements Serializable {

	
	private String Hastalik;//255
	private static final long serialVersionUID = 1L;

	public KritikHastalik() {
		super();
		setCreatedTime(Calendar.getInstance());
	}   
	public String getHastalik() {
		return this.Hastalik;
	}

	public void setHastalik(String Hastalik) {
		this.Hastalik = Hastalik;
	}
   
}
