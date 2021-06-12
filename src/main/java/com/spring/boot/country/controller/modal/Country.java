package com.spring.boot.country.controller.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
	private String code;
	private String name;
	private String description;
	private String continent;
	private String region;
	private long population;
}
