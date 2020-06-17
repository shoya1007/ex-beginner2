package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.service.MemberService;

@Controller
@RequestMapping("/ex05")
public class Exam05 {
	@Autowired
	private MemberService service;

	@RequestMapping("")
	public String index() {
		return "exam05";
	}

	@RequestMapping("/execute")
	public String findByName(String partOfName, Model model) {
		List<Member> memberList = service.findByName(partOfName);
		model.addAttribute("memberList", memberList);
		return "exam05-result";
	}
}
