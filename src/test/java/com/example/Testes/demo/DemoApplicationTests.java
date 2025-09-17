package com.example.Testes.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		// This test verifies that the Spring Boot context loads successfully
		Assertions.assertTrue(true, "Spring Boot context should load successfully");
	}
	
	@Test
	void verifyJUnit5Working() {
		// This test verifies that JUnit 5 is working properly
		String expected = "JUnit 5 is working";
		String actual = "JUnit 5 is working";
		
		Assertions.assertEquals(expected, actual, "JUnit 5 assertions should work");
		Assertions.assertNotNull(actual, "Value should not be null");
	}

}
