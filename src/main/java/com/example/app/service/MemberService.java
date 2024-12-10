package com.example.app.service;

import java.util.List;

import com.example.app.domain.Member;

public interface MemberService {
	List<Member> getAllMember();

	//個別
	Member getMemberById(Integer id);

	//年齢で絞り込み検索、名前検索、全件取得
	List<Member> search(String keyword, Integer from, Integer to);

	//新規追加
	void register(Member member);
	
	//名前検索
	
	//削除
	void deleteMember(Integer id);

	//更新
	void editMember(Member member);
}
