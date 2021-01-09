package org.galvanize.jpademo.Tea;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaService {

    TeaRepository repository;

    public TeaService(TeaRepository repository) {
        this.repository = repository;
    }

    public List<Tea> findAll() {
        return repository.findAll();
    }

    public Tea save(Tea tea) {
        return repository.save(tea);
    }
}
