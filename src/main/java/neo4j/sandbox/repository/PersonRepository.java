package neo4j.sandbox.repository;

import neo4j.sandbox.model.Person;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface PersonRepository extends GraphRepository<Person> {
}
