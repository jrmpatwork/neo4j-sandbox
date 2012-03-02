package neo4j.sandbox.service;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import neo4j.sandbox.model.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/graph-test-context.xml" })
public class PersonServiceTest {

    private static final String STATUS = "a status";
    
    @Resource
    private PersonService personService;
  
    @Test
    public void testStatusUpdate() throws Exception {
        Long id = personService.save(new Person()).getId();
        
        personService.updateStatus(id, STATUS);
        Person person = personService.find(id);
        assertEquals(STATUS, person.currentStatus().getEntry());
    }
}
