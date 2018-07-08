package tr.com.deneme.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tr.com.deneme.entities.Person;
import tr.com.deneme.service.PersonService;

@ManagedBean
@RequestScoped
public class ListeleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Person person = new Person();
	private boolean isUpdateButtonShown = false;
	private PersonService personService;

	@PostConstruct
	public void init() {
		personService = new PersonService();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public boolean isUpdateButtonShown() {
		return isUpdateButtonShown;
	}

	public void setUpdateButtonShown(boolean isUpdateButtonShown) {
		this.isUpdateButtonShown = isUpdateButtonShown;
	}

	public List<Person> kisileriGetir() {
		return personService.KisileriGoster();
	}

	public String KisiGuncelle() {
		return "listele";
	}

	public String KisiSec(Long id) {
		Person person = personService.KisiGoster(id);
		setPerson(person);
		setUpdateButtonShown(true);
		return "listele";
	}

}
