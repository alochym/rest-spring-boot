package com.github.alochym;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.alochym.entities.Location;
import com.github.alochym.handlers.LocationAPIController;
import com.github.alochym.services.LocationService;

@WebMvcTest(LocationAPIController.class)
public class LocationAPIControllerTest {
    private static final String END_POINT_PATH = "/api/v1/locations";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private LocationService lsrv;

    @Test
    public void testAddFailWith400BadRequest() throws Exception {
        Location l = new Location();

        String bodyContent = this.mapper.writeValueAsString(l);

        // to make a HTTP post request to /api/v1/locations.
        this.mockMvc.perform(
                post(END_POINT_PATH).contentType("application/json").content(bodyContent))
                // check response status code.
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testAddSuccessWith201() throws Exception {

        Location l = new Location();

        l.setAddress("1900 Federal ct");

        // Create a a Mock for Service Layer.
        // Step 01.
        Mockito.when(this.lsrv.addLocation(l)).thenReturn(l);

        String bodyContent = this.mapper.writeValueAsString(l);

        // to make a HTTP post request to /api/v1/locations.
        // the result is a response from Mockito - Step 01.
        this.mockMvc.perform(
                post(END_POINT_PATH).contentType("application/json").content(bodyContent))
                // check response status code.
                .andExpect(MockMvcResultMatchers.status().isCreated())
                // check the response Header contentType
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }
}
