package org.galvanize.jpademo.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

  @Autowired
  LocationService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Location createLocation(@RequestBody Location location) {
    return service.save(location);
  }

}
