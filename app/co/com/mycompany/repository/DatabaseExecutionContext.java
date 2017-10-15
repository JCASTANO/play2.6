package co.com.mycompany.repository;

import javax.inject.Inject;

import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;

/**
 * Custom execution context wired to "database.dispatcher" thread pool
 */
public class DatabaseExecutionContext extends CustomExecutionContext {

    private static final String NAME = "database.dispatcher";

    @Inject
    public DatabaseExecutionContext(ActorSystem actorSystem) {
        super(actorSystem, NAME);
    }
}
