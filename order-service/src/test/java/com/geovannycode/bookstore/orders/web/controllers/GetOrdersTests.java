package com.geovannycode.bookstore.orders.web.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.geovannycode.bookstore.orders.AbstractIT;
import com.geovannycode.bookstore.orders.WithMockOAuth2User;
import org.junit.jupiter.api.Test;

public class GetOrdersTests extends AbstractIT {
    @Test
    @WithMockOAuth2User(username = "user")
    void shouldGetOrdersSuccessfully() throws Exception {
        mockMvc.perform(get("/api/orders")).andExpect(status().isOk());
    }
}
