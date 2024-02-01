package com.sparadrapweb.sapradrapWeb.controleur;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Test
    public void testGetPatient() throws Exception {
            mockMvc.perform(get("/Patient"))
            .andExpect(status().is3xxRedirection()) 
            .andExpect(redirectedUrl("http://localhost/login"));

    }
}