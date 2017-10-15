package co.com.mycompany.repository;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import co.com.mycompany.domain.Person;

public class MysqlPersonRepository implements PersonRepository {
	
	private final DatabaseExecutionContext executionContext;
	
	@Inject
	public MysqlPersonRepository(DatabaseExecutionContext executionContext) {
		this.executionContext = executionContext;
	}

	@Override
	public CompletionStage<Person> find() {
		return supplyAsync(this::findPersonWithBlock, executionContext);
	}

	private Person findPersonWithBlock() {
		sleep();
		return new Person("Juan Esteban", "castano rincon");
	}

	private void sleep() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
