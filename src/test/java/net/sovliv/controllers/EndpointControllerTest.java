package net.sovliv.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EndpointController.class)
public class EndpointControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void endpointA() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/endpoint/endpointA?number=123"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void endpointB() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/endpoint/endpointB?number=1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
