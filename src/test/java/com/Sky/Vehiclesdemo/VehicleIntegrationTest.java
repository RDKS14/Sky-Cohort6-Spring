package com.Sky.Vehiclesdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.Sky.Vehiclesdemo.domain.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:vehicle-schema.sql", "classpath:vehicle-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class VehicleIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {

        Vehicle testVehicle = new Vehicle("Spider", 4, "Ferrari", 4, 2, 4);
        String reqBody = this.mapper.writeValueAsString(testVehicle);
        System.out.println("VEHICLE: " + testVehicle);
        System.out.println("JSON: " + reqBody);

        RequestBuilder req = post("/create").content(reqBody).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = status().isCreated();
        testVehicle.setID(4);
        String resBody = this.mapper.writeValueAsString(testVehicle);
        System.out.println("SAVED VEHICLE: " + testVehicle);
        System.out.println("RES JSON: " + reqBody);
        ResultMatcher checkBody = content().json(resBody);

        mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testCreate2() throws Exception {
        String reqBody = this.mapper.writeValueAsString(new Vehicle("Urus", 4, "Lamborghini", 4, 2, 7));

        String resBody = this.mapper.writeValueAsString(new Vehicle("Urus", 4, "Lamborghini", 4, 2, 7));

        mvc.perform(post("/create").content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andExpect(content().json(resBody));
    }

    @Test
    void testRead() throws Exception {
        String resBody = this.mapper.writeValueAsString(new Vehicle("Arona", 2, "SEAT", 4, 4, 1));
        this.mvc.perform(MockMvcRequestBuilders.get("/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));
    }

    @Test
    void testReadAll() throws Exception {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Arona", 2, "SEAT", 4, 4, 1));
        vehicles.add(new Vehicle("Ibiza", 2, "SEAT", 4, 4, 2));
        vehicles.add(new Vehicle("ATECA", 2, "SEAT", 4, 4, 3));

        String resBody = this.mapper.writeValueAsString(vehicles);
        this.mvc.perform(MockMvcRequestBuilders.get("/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));

    }

    @Test
    void testPatch() throws Exception {
        String reqBody = this.mapper.writeValueAsString(new Vehicle("Arona", 2, "SEAT", 4, 4, 1));
        String resBody = this.mapper.writeValueAsString(new Vehicle("Arona", 4, "SEAT", 4, 4, 1));
        this.mvc.perform(MockMvcRequestBuilders.patch("/update/?name=Arona&age=4&brand=SEAT&wheels=4&doors=4&id=1").content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));
    }
    @Test
    void testDelete() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.delete("/remove/2"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}