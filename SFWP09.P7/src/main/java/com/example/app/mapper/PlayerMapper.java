package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Player;

//playersテーブルを操作するインターフェース
//DAOのようなimage
@Mapper
public interface PlayerMapper {
	//一覧
	List<Player> selectAll();
	
	//個別
	Player selectById(int id);
	
	//登録
	void add(Player player);
	
	//変更
	void edit(Player player);
	
	//削除
	void deleteById(int id);
	
}
