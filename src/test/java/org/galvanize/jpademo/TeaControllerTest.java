package org.galvanize.jpademo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.galvanize.jpademo.Location.Location;
import org.galvanize.jpademo.Location.LocationRepository;
import org.galvanize.jpademo.Location.LocationService;
import org.galvanize.jpademo.Tea.Tea;
import org.galvanize.jpademo.Tea.TeaController;
import org.galvanize.jpademo.Tea.TeaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class TeaControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    LocationRepository locationRepository;

    @Test
    void smoke() {
        assertTrue(true);
    }

    @Test
    void getAllTea() throws Exception {
        mvc
          .perform(get("/api/teas"))
          .andExpect(status().isOk())
          .andExpect(content().contentType(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void createTeaWithLocation() throws Exception {
        Location tealand = new Location("Tealand");
        locationRepository.save(tealand);

        Tea tealandTea = new Tea();
        tealandTea.setOrigin(tealand);

        mvc
          .perform(
            post("/api/teas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tealandTea))
          )
          .andExpect(status().isCreated())
          .andExpect(jsonPath("$.origin.id").value(1))
          .andExpect(jsonPath("$.origin.name").value(tealand.getName()));

    }
}
