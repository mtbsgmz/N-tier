package tr.com.deneme.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import tr.com.deneme.service.PersonService;

public class DavutBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PersonService personService;

	@PostConstruct
	public void init() {
		personService = new PersonService();
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
