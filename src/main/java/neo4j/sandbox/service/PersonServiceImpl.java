package neo4j.sandbox.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neo4j.sandbox.model.Person;
import neo4j.sandbox.model.Status;
import neo4j.sandbox.repository.PersonRepository;
import neo4j.sandbox.repository.StatusRepository;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonRepository personRepository;

    @Resource
    private StatusRepository statusRepository;
    
    public void updateStatus(Long memberId, String statusUpdate) {
        Person person = personRepository.findOne(memberId);
        Status status = new Status(statusUpdate);
        person.updateStatus(status);
        personRepository.save(person);
    }
    
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person find(Long id) {
        return personRepository.findOne(id);
    }
    
}