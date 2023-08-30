package com.promineotech.jeep.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.promineotech.jeep.controller.support.CreateOrderTestSupport;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.JeepModel;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = { "classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
		"classpath:flyway/migrations/V1.1__Jeep_Data.sql" }, config = @SqlConfig(encoding = "utf-8"))
public class CreateOrderTest extends CreateOrderTestSupport {

    @LocalServerPort
    private int serverPort;
    
    @Autowired
    private TestRestTemplate restTemplate;
   
    
    @Test
    public void testGetRequest() throws Exception{
        String uri = String.format("http://localhost:%d/orders", serverPort);
//
//        //setting up the mock server with url
//        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate.getRestTemplate());
//
//        mockServer.expect(ExpectedCount.manyTimes(), MockRestRequestMatchers.requestTo(uri))
//                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
//                .andRespond(MockRestResponseCreators.withSuccess("Hi Mom!", MediaType.TEXT_PLAIN));
//
        void testCreateOrderReturnsSuccess201() {
        String body = createOrderBody();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response1 = restTemplate.getForEntity("/orders", String.class);


        HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
        ResponseEntity<Order> response = restTemplate.exchange(uri,HttpMethod.POST, bodyEntity, Order.class);
//        ResponseEntity<Order> response = mockMvc.exchange(uri,HttpMethod.POST, bodyEntity, Order.class);
        
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        assertThat(response.getBody()).isNotNull();
//        Order order = response.getBody();
//        assertThat(order.getCustomer().getCustomerId()).isEqualTo("ROTH_GARTH");
//        assertThat(order.getModel().getModelId()).isEqualTo(JeepModel.WRANGLER);
//        assertThat(order.getModel().getTrimLevel()).isEqualTo("Rubicon");
//        assertThat(order.getModel().getNumDoors()).isEqualTo(4);
//        assertThat(order.getColor().getColorId()).isEqualTo("EXT_SNAZZBERRY");
//        assertThat(order.getEngine().getEngineId()).isEqualTo("2_0_TURBO");
//        assertThat(order.getTire().getTireId()).isEqualTo("255_GOODYEAR");
//        assertThat(order.getOptions()).hasSize(6);
    }

}

