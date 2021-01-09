package org.galvanize.jpademo.Tea;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        tea.setId(UUID.randomUUID().toString());
        return repository.save(tea);
    }
}
