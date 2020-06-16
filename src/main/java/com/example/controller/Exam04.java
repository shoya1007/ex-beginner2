package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.domain.UserForm;

@Controller
@RequestMapping("/ex04")
public class Exam04 {
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	@RequestMapping("")
	public String index() {
		return "exam04";
	}
	
	@RequestMapping("/result")
	public String result(@Validated UserForm form,BindingResult result, String name,String age,String comment,Model model) {
		if(result.hasErrors()) {
			return index();
		}
		User user=new User();
		user.setName(name);
		user.setAge(age);
		user.setComment(comment);
		model.addAttribute("user",user);
		return "exam04-result";
	}
}
