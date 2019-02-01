package com.faizal.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faizal.spring5webapp.repository.BookJpaRepository;

@Controller
public class BookController {

	private BookJpaRepository bookJpaRepository;

	public BookController(BookJpaRepository bookJpaRepository) {
		super();
		this.bookJpaRepository = bookJpaRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookJpaRepository.findAll());
		return "books";
	}
}
