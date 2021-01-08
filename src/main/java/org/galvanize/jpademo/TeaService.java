package org.galvanize.jpademo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeaService {

    public List<Tea> findAll() {
        return new ArrayList<>();
    }
}
