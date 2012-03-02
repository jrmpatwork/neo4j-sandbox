package neo4j.sandbox.infrastructure;

import java.util.Collection;
import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.event.TransactionEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventHandlerRegistrar {

    @Autowired
    private ApplicationContext applicationContext;

    public void init() {
        Map<String, TransactionEventHandler> eventHandlerMap = applicationContext.getBeansOfType(TransactionEventHandler.class);
        GraphDatabaseService graphDatabaseService = applicationContext.getBean(GraphDatabaseService.class);
        Collection<TransactionEventHandler> transactionEventHandlers = eventHandlerMap.values();
        for (TransactionEventHandler transactionEventHandler : transactionEventHandlers) {
            graphDatabaseService.registerTransactionEventHandler(transactionEventHandler);
        }
    }

}
