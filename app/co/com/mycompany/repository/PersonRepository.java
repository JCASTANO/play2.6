package co.com.mycompany.repository;

import java.util.concurrent.CompletionStage;

import com.google.inject.ImplementedBy;

import co.com.mycompany.domain.Person;

@ImplementedBy(MysqlPersonRepository.class)
public interface PersonRepository {

   /**
    * Allows find a person
    * @return
    */
   CompletionStage<Person> find();
}
