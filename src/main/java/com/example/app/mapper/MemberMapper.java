package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Member;

@Mapper
public interface MemberMapper {
	//一覧
	List<Member> selectAll();

	//個別
	Member selectById(Integer id);

	//追加
	void add(Member member);
	
	//削除
	void delete(Integer id);
	
	//年齢で絞り込み
	List<Member> selectByAge(
			@Param("from") Integer from,
			@Param("to") Integer to);

	//名前検索
	List<Member> selectByName(String keyword);

	void update(Member member);
	
	void editMember(Member member);
}
