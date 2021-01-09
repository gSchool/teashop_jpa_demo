package org.galvanize.jpademo.Tea;

import org.galvanize.jpademo.Location.Location;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tea {

    @Id
    private String id;

    @ManyToOne(cascade=CascadeType.ALL)
    private Location origin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }
}
