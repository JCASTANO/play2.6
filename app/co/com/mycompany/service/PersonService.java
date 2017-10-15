package co.com.mycompany.service;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import co.com.mycompany.domain.Person;
import co.com.mycompany.repository.PersonRepository;

public class PersonService {

	private PersonRepository personRepository;
	
	@Inject
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public CompletionStage<Person> find() { 
		return this.personRepository.find();
	}
}
