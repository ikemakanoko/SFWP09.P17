package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Team;

//teamsテーブルを操作するインターフェース
//DAOのようなimage
@Mapper
public interface TeamMapper {
	//一覧
	List<Team> selectAll();
	
	//個別
	Team selectById(int id);
	
	//追加
	void add(Team team);
	
}
