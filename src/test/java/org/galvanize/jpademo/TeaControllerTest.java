package org.galvanize.jpademo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.galvanize.jpademo.Location.Location;
import org.galvanize.jpademo.Location.LocationService;
import org.galvanize.jpademo.Tea.Tea;
import org.galvanize.jpademo.Tea.TeaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
public class TeaControllerTest {
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    LocationService locationService;

    @MockBean
    TeaService teaService;

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
        objectMapper = new ObjectMapper();
        Location tealand = createNewLocation();
        Tea tealandTea = createNewTea();
        tealandTea.setOrigin(tealand);

        when(teaService.save(any(Tea.class))).thenReturn(tealandTea);

        mvc
          .perform(
            post("/api/teas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tealandTea))
          )
          .andExpect(status().isCreated())
          .andExpect(jsonPath("$.origin.id").value(tealand.getId()))
          .andExpect(jsonPath("$.origin.name").value(tealand.getName()));

    }

    // Test Utilities -------

    public Location createNewLocation() {
        Location location = new Location("Tealand");
        location.setId(12);
        return location;
    }

    public Tea createNewTea() {
        Tea tea = new Tea();
        return tea;
    }
}
