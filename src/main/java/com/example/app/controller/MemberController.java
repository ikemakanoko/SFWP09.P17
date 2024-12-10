package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Member;
import com.example.app.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService service;

	@GetMapping("/members")
	public String list(
			Model model,
			@RequestParam(name = "from", required = false) Integer from,
			@RequestParam(name = "to", required = false) Integer to,
			@RequestParam(name = "keyword", required = false) String keyword) {
		List<Member> members = service.search(keyword, from, to);
		model.addAttribute("members", members);
		return "list";
	}

	//個別
	@GetMapping("/member")
	public String member(
			Model model,
			@RequestParam Integer id) {
		System.out.println(service.getMemberById(id));
		model.addAttribute("member", service.getMemberById(id));
		return "member";
	}

	//新規追加
//	@GetMapping("/add")
	public String add(Model model) {
		//memberドメインクラスをthymeleafで使えるようにする
		model.addAttribute("member", new Member());
		return "add";
	}

//	@PostMapping("/add")
	public String add(
			@Valid Member member,
			Errors errors
			) {
		if (errors.hasErrors()) {
			return "add";
		}
		//DB登録
		service.register(member);
		return "redirect:/members";
	}
	
	//削除
	@GetMapping("/delete")
	public String delete(
			@RequestParam(name="id", required = false) Integer id
			) {
		if (id != null) {
			service.deleteMember(id);
		}
		return "redirect:/members";
	}
	//更新
	@GetMapping("/edit")
	public String edit(
			Model model,
			@RequestParam Integer id
			) {
		model.addAttribute("member", service.getMemberById(id));
		return "edit";
	}
	
	@PostMapping("/edit")
	public String edit(
			@Valid Member member,
			Errors errors
			) {
		if (errors.hasErrors()) {
			return "edit";
		}
		//DB更新
		service.editMember(member);
		return "redirect:/members";
	}
	
}
