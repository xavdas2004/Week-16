package com.promineotech.jeep.entity;

import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.flyway.FlywayProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Jeep {
	private Long modelPK;
	private JeepModel modelId;
	private String trimLevel;
	private int numDoors;
	private int wheelSize;
	private BigDecimal basePrice;

	@TestConfiguration
	public class TestFlywayConfig {

		@MockBean
		private FlywayProperties flywayProperties;

		public TestFlywayConfig() {

			flywayProperties.setLocations("classpath:db/migration");
		}
	}
}
