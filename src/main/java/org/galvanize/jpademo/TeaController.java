package org.galvanize.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeaController {

    @Autowired
    TeaService service;

    @GetMapping("/api/teas")
    public List<Tea> getAllTea() {
        return service.findAll();
    }
}
