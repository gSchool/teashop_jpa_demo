package org.galvanize.jpademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest(TeaController.class)
public class TeaControllerTest {
    @Autowired
    MockMvc mvc;


    @Test
    void smoke() {
        assertTrue(true);
    }
}
