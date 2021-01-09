package org.galvanize.jpademo.Location;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

  @Id
  @GeneratedValue
  private Integer id;


  @NonNull
  private String name;

  public Location() {

  }

  public Location(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }
  public void setId(int locId) { this.id = locId; }

  public String getName() {
    return name;
  }
}
