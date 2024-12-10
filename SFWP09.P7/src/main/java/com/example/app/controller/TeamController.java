package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Team;
import com.example.app.mapper.TeamMapper;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamController {
	private final TeamMapper teammapper;
	//一覧
	@GetMapping
	public String list(Model model) {
		List<Team> teams =
				teammapper.selectAll();
		model.addAttribute("teams", teams);
		return "teamList";
	}
	//個別
	//新規
	//更新
	//削除
}
