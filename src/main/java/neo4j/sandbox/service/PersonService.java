package neo4j.sandbox.service;

import neo4j.sandbox.model.Person;

public interface PersonService {

    Person save(Person person);

    Person find(Long id);
    
    void updateStatus(Long memberId, String status);

}
