package org.galvanize.jpademo.Location;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

  LocationRepository repository;

  public LocationService(LocationRepository repository) {
    this.repository = repository;
  }

  public Location save(Location location) {
    return repository.save(location);
  }

}
