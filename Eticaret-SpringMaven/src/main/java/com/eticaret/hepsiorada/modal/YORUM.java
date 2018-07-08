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
 * Entity implementation class for Entity: YORUM
 *
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "Yorum.findAll", query = "select yor from YORUM yor"), 
	@NamedQuery(name = "Yorum.findById", query = "select yor from YORUM yor where yor.ID=:YORID", lockMode = READ) 
})
@Where(clause="DELETED=false and ACTIVE=true")
public class YORUM extends BaseEntity implements Serializable {

	private String YORUM;

	@ManyToOne
	@JoinColumn(name = "URUN_ID", referencedColumnName = "ID")
	private URUN URUN;
	
	@ManyToOne
	private KULLANICI KULLANICI;

	private static final long serialVersionUID = 1L;

	public YORUM() {
		super();
	}

	public String getYORUM() {
		return this.YORUM;
	}

	public void setYORUM(String YORUM) {
		this.YORUM = YORUM;
	}

}
