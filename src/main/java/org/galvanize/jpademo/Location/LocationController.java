package org.galvanize.jpademo.Location;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

  LocationService service;

  public LocationController(LocationService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Location createLocation(@RequestBody Location location) {
    return service.save(location);
  }

}
