package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Player;
import com.example.app.mapper.PlayerMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
	
	private final PlayerMapper playermapper;
	
	//一覧
	@GetMapping
	public String list(Model model) {
		//一覧データ取得
		List<Player> players = 
						playermapper.selectAll();
		model.addAttribute("players", players);
		return "list";
	}
	
	//個別
	@GetMapping("/show")
	public String Show() {
		return "show";
	}
	
	//追加
	
	
	//更新
	
	
	//削除
	
	
}
