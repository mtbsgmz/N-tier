package tr.com.deneme.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tr.com.deneme.entities.Person;
import tr.com.deneme.service.PersonService;

@ManagedBean
@RequestScoped
public class PersonBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ad;
	private String soyad;
	private String tel;
	private String tc;
	private String adres;
	private PersonService personService;

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	@PostConstruct
	public void init() {
		personService = new PersonService();
	}

	public void Kaydet() {
		System.out.println(toString());
		Person person = new Person();
		person.setAd(getAd());
		person.setSoyad(getSoyad());
		person.setTc(getTc());
		person.setTel(getTel());
		person.setAdres(getAdres());
		personService.KisiEkle(person);
	}

	
	@Override
	public String toString() {
		return "Kisi [ad=" + ad + ", soyad=" + soyad + ", tc=" + tc + ", tel=" + tel + ", adres=" + adres + "]";
	}
}
