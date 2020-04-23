package com.juno.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}

	@RequestMapping("/view/member")
	public String viewMember() {
		return "Member.html View!";
	}
}
