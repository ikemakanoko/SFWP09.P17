package com.example.app.domain;

import java.time.LocalDate;

import lombok.Data;

// playersテーブルのデータ格納
@Data
public class Player {
	private Integer id;
	private String name;
	private Integer age;
	private Integer teamId; //team_idをキャメルケース
	private String position;
	private LocalDate birthday;
}
