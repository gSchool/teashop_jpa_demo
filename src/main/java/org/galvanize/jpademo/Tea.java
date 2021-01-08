package org.galvanize.jpademo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tea {
    @Id
    private String id;
}
