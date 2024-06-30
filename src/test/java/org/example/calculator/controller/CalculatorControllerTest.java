package org.example.calculator.controller;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenValidAddRequest_whenAdd_shouldReturnOkAndSum() throws Exception {
        double a = Double.MAX_VALUE;
        double b = 33;
        this.mockMvc.perform(post("/api/calculator/add")
                        .queryParam("a", String.valueOf(a))
                        .queryParam("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value(a+b));
    }

    @Test
    void givenNotNumberParameter_whenAdd_shouldReturnBadRequest() throws Exception {
        this.mockMvc.perform(post("/api/calculator/add")
                        .queryParam("a", "Hallo!")
                        .queryParam("b", "24323"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenValidSubRequest_whenSub_shouldReturnOkAndSubtraction() throws Exception {
        double a = 66.66;
        double b = 33.33;
        this.mockMvc.perform(post("/api/calculator/sub")
                        .queryParam("a", String.valueOf(a))
                        .queryParam("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value(a-b));
    }

    @Test
    void givenValidMulRequest_whenMul_shouldReturnOkAndMultiplication() throws Exception {
        double a = 66.66;
        double b = 33.33;
        this.mockMvc.perform(post("/api/calculator/mul")
                        .queryParam("a", String.valueOf(a))
                        .queryParam("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value(a*b));
    }

    @Test
    void givenValidDivRequest_whenDiv_shouldReturnOkAndDivision() throws Exception {
        double a = 66.66;
        double b = 0.000000001;
        this.mockMvc.perform(post("/api/calculator/div")
                        .queryParam("a", String.valueOf(a))
                        .queryParam("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value(a/b));
    }

    @Test
    void givenInvalidSecondParameter_whenDiv_shouldReturnBadRequest() throws Exception {
        this.mockMvc.perform(post("/api/calculator/div")
                        .queryParam("a", "1212.4545")
                        .queryParam("b", "0"))
                .andExpect(status().isBadRequest());
    }

}