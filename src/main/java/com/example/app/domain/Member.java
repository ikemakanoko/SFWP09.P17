package com.example.app.domain;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Member {
	private Integer id;
	@NotBlank(message = "氏名は必須です")
	private String name;
	
	@NotNull(message = "年齢は必須です")
	@Range(min = 0, max = 150, message = "年齢は0~150の間で")
	private Integer age;
	
	private Integer typeId;
	private String address;
	private LocalDateTime created;
}