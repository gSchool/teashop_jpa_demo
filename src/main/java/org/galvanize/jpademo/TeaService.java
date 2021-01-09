package org.galvanize.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeaService {

    TeaRepository repository;

    public List<Tea> findAll() {
        return repository.findAll();
    }
}
