package co.com.mycompany.controller;

import static play.libs.Json.toJson;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import co.com.mycompany.service.PersonService;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

public class PersonController extends Controller {

    private final PersonService personService;
    private final HttpExecutionContext ec;

    @Inject
    public PersonController(HttpExecutionContext ec,PersonService personService) {
        this.personService = personService;
        this.ec = ec;
    }

    public CompletionStage<Result> get() { 
        return personService.find().thenApplyAsync(person -> 
            ok(toJson(person)).as("application/json;charset=utf-8")
        , ec.current());
    }
}
