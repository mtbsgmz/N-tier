package com.entities;

import com.entities.BaseEntitiy;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Arac
 *
 */
@Entity

public class Arac extends BaseEntitiy implements Serializable {

	
	private String PLAKA;
	private static final long serialVersionUID = 1L;

	public Arac() {
		super();
	}

	public String getPLAKA() {
		return PLAKA;
	}

	public void setPLAKA(String pLAKA) {
		PLAKA = pLAKA;
	}   

   
}
