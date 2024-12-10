package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Member;
import com.example.app.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImp implements MemberService {
	private final MemberMapper mapper;

	@Override
	public List<Member> getAllMember() {
		//複雑なデータ処理はこのserviceで行う
		return mapper.selectAll();
	}

	@Override
	public Member getMemberById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return mapper.selectById(id);
	}

	@Override
	public List<Member> search(String keyword, Integer from, Integer to) {
		List<Member> members = null;
		if (keyword != null) {
			members = mapper.selectByName(keyword);
		} else if (from != null && to != null) {
			//年齢検索結果
			members = mapper.selectByAge(from, to);
		} else {
			//全権結果
			members = mapper.selectAll();
		}
		return members;

	}

	@Override
	public void register(Member member) {
		mapper.add(member);
	}

	@Override
	public void deleteMember(Integer id) {
		mapper.delete(id);
	}

	@Override
	public void editMember(Member member) {
		mapper.update(member);
		
	}
}
