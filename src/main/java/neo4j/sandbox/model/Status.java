package neo4j.sandbox.model;

import java.util.Date;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Status {

    @GraphId
    private Long id;
    
    private String entry;
    
    private Date created;

    public Status() {}
    
    public Status(String entry) {
        this.entry = entry;
        this.created = new Date();
    }
    
    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
}
