package neo4j.sandbox.service;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import neo4j.sandbox.model.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
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
        Long personId = personService.save(new Person()).getId();
        
        personService.updateStatus(personId, STATUS);
        Person person = personService.find(personId);
        assertEquals(STATUS, person.currentStatus().getEntry());
    }
}
