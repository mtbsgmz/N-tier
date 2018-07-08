package tr.com.deneme.service;

import java.util.List;

import tr.com.deneme.dao.PersonDAO;
import tr.com.deneme.entities.Person;

public class PersonService {
	PersonDAO personDao = new PersonDAO();

	public void KisiEkle(Person kisi) {
		personDao.create(kisi);
	}

	/*
	 * public void KisiGuncelle(Person kisi) { personDao.update(kisi);
	 * 
	 * }
	 */

	public Person KisiGoster(Long id) {
		return personDao.read(id);
	}

	public List<Person> KisileriGoster() {
		return personDao.readAll();
	}
}
