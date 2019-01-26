package com.faizal.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faizal.spring5webapp.repository.AuthorJpaRepository;
import com.faizal.spring5webapp.repository.BookJpaRepository;

@Controller
public class AuthorController {

	private AuthorJpaRepository authorJpaRepository;

	public AuthorController(AuthorJpaRepository authorJpaRepository) {
		super();
		this.authorJpaRepository = authorJpaRepository;
	}

	@RequestMapping("/authors")
	public String getBooks(Model model) {
		model.addAttribute("authors", authorJpaRepository.findAll());
		return "authors";
	}
}
