package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.MemberRepository;
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
	/*public String findById(Integer id,Model model) {
		MemberRepository repository=new MemberRepository();
		Member member=repository.load(id);
		String name=member.getName();
		model.addAttribute("name", name);
		return "exam05-result";
	}*/
	public String findByName(String partOfName,Model model) {
		List<Member> memberList=service.findByName(partOfName);
		model.addAttribute("memberList",memberList);
		return "exam05-result";
	}
	
	/*public String find(Model model) {
		
		List<Member> memberList=service.find();
		model.addAttribute("memberList",memberList);
		return "exam05-result";
	}*/
}
