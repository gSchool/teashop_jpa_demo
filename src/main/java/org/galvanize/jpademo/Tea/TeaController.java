package org.galvanize.jpademo.Tea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teas")
public class TeaController {

    TeaService service;

    public TeaController(TeaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tea> getAllTea() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tea createTea(@RequestBody Tea tea) {
        return service.save(tea);
    }
}
