package com.example.app.domain;

import java.time.LocalDate;

import lombok.Data;

//teamsテーブルのデータ格納
@Data
public class Team {
	private Integer id;
	private String name;
	private String place;
	//established_atをキャメルケース
	private LocalDate establishedAt;
	
}
