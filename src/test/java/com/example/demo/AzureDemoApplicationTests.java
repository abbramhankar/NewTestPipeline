package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class AzureDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void statusShouldBeOk() throws Exception {
		this.mockMvc.perform(get("/api/hello"))
					.andDo(print())
					.andExpect(status().isOk());
	}
}
