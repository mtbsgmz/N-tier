package com.eticaret.hepsiorada.modal;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: Kullanici
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Kullanici.findAll", query = "select kul from KULLANICI kul"),
		@NamedQuery(name = "Kullanici.findById", query = "select kul from KULLANICI kul WHERE kul.ID =:KULID") })
@Where(clause = "DELETED=false and ACTIVE=true")
public class KULLANICI extends BaseEntity implements Serializable {

	private String AD;
	private String SOYAD;
	private String EMAIL;
	private String TCNO;

	@Enumerated(STRING)
	private KULLANICITIP TIP;

	@Transient
	private String openTip="";

	private static final long serialVersionUID = 1L;

	public KULLANICI() {
		super();
	}

	public String getOpenTip() {
		KULLANICITIP kultip = getTIP();
		if(kultip!=null)
		switch (kultip) {
		case ADMIN:
			openTip = "Admin";
			break;
		case CMADMIN:
			openTip = "��erik Y�neticisi";
			break;
		case LUSER:
			openTip = "Son Kullan�c�";
			break;
		case SADMIN:
			openTip = "S�per Admin";
			break;
		default:
			openTip = "Bilinmiyor";
			break;
		}
		return openTip;
	}

	public void setOpenTip(String openTip) {
		this.openTip = openTip;
	}

	public KULLANICITIP getTIP() {
		return TIP;
	}

	public void setTIP(KULLANICITIP tIP) {
		TIP = tIP;
	}

	public String getAD() {
		return this.AD;
	}

	public void setAD(String AD) {
		this.AD = AD;
	}

	public String getSOYAD() {
		return this.SOYAD;
	}

	public void setSOYAD(String SOYAD) {
		this.SOYAD = SOYAD;
	}

	public String getEMAIL() {
		return this.EMAIL;
	}

	public void setEMAIL(String EMAIL) {
		this.EMAIL = EMAIL;
	}

	public String getTCNO() {
		return this.TCNO;
	}

	public void setTCNO(String TCNO) {
		this.TCNO = TCNO;
	}

}
