package org.galvanize.jpademo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeaController {

    @GetMapping("/api/teas")
    public List<Tea> getAllTea() {
        return new ArrayList<>();
    }
}
