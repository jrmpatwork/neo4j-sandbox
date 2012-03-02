package neo4j.sandbox.repository;

import neo4j.sandbox.model.Status;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface StatusRepository extends GraphRepository<Status> {
}
