package com.eticaret.hepsiorada.modal;

import static javax.persistence.GenerationType.TABLE;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Entity implementation class for Entity: BaseEntity
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = TABLE, generator = "TABLEGEN")
	@TableGenerator(name = "TABLEGEN", allocationSize = 1, initialValue = 1)
	private Long ID;
	
	
	@Temporal(TIMESTAMP)
	private Calendar CREATEDDATE = Calendar.getInstance();
	
	@Temporal(TemporalType.DATE)
	private Calendar UPDATEDATE;
	
	private Boolean DELETED=false;
	
	@Version
	private Long VERSION;
	
	private Boolean ACTIVE=true;
	
	private static final long serialVersionUID = 1L;

	public BaseEntity() {
		super();
	}   
	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}   
	public Calendar getCREATEDDATE() {
		return this.CREATEDDATE;
	}

	public void setCREATEDDATE(Calendar CREATEDDATE) {
		this.CREATEDDATE = CREATEDDATE;
	}   
	public Calendar getUPDATEDATE() {
		return this.UPDATEDATE;
	}

	public void setUPDATEDATE(Calendar UPDATEDATE) {
		this.UPDATEDATE = UPDATEDATE;
	}   
	public Boolean getDELETED() {
		return this.DELETED;
	}

	public void setDELETED(Boolean DELETED) {
		this.DELETED = DELETED;
	}   
	public Long getVERSION() {
		return this.VERSION;
	}

	public void setVERSION(Long VERSION) {
		this.VERSION = VERSION;
	}   
	public Boolean getACTIVE() {
		return this.ACTIVE;
	}

	public void setACTIVE(Boolean ACTIVE) {
		this.ACTIVE = ACTIVE;
	}
   
}
