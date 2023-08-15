package com.promineotech.jeep.controller;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
"classpath:flyway/migrations/V1.0_Jeep_Schema.sql",
"classpath:flyway/migrations/V1.1_Jeep_Data.sql"},
config = @SqlConfig(encoding = "utf-8"))
@SpringJUnitConfig(TestFlywayConfig.class)
class FetchJeepTest{
	
	@Test
	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri = String.format("http://localhost:%d/jeeps?model=%s&trim=%s", serverPort, model, trim);
		ResponseEntity<List<Jeep>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	
		List<Jeep> expectedJeeps = buildExpected();
		
		List<Jeep> actualJeeps = response.getBody();
		
		assertThat(actualJeeps).isEqualTo(expectedJeeps);
	}
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	
	private int serverPort;	protected List<Jeep> buildExpected() {
	    List<Jeep> expectedJeep = new LinkedList<>();
	    //@formatter off
	    expectedJeep.add(Jeep.builder()
	        .modelId(JeepModel.WRANGLER)
	        .trimLevel("Sport")
	        .numDoors(2)
	        .wheelSize(17)
	        .basePrice(new BigDecimal("28475.00"))
	        .build());

	    expectedJeep.add(Jeep.builder()
	        .modelId(JeepModel.WRANGLER)
	        .trimLevel("Sport")
	        .numDoors(4)
	        .wheelSize(17)
	        .basePrice(new BigDecimal("31975.00"))
	        .build());
	    //@formatter on
	    return expectedJeep;
	}
	
}