package com.greatlearning.studentfest.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@GetMapping("/user")
	public @ResponseBody String getLoggedInUser(Principal principal)
	{
		System.out.println("get logged in user");
		return principal.getName();
	}
	@GetMapping("/")
	public String getHomePage()
	{
		System.out.println("home page");
		return "redirect:/list";
	}
}
