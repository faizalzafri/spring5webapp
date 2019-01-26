package com.faizal.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.faizal.spring5webapp.model.Author;
import com.faizal.spring5webapp.model.Book;
import com.faizal.spring5webapp.repository.AuthorJpaRepository;
import com.faizal.spring5webapp.repository.BookJpaRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorJpaRepository authorJpaRepository;
	private BookJpaRepository bookJpaRepository;

	public DevBootstrap(AuthorJpaRepository authorJpaRepository, BookJpaRepository bookJpaRepository) {
		super();
		this.authorJpaRepository = authorJpaRepository;
		this.bookJpaRepository = bookJpaRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();

	}

	private void initData() {
		// TODO Auto-generated method stub

		Author josh = new Author("Josh", "Long");
		Book bookOne = new Book("Spring Boot 101", "22334", "Pivotal Inc.");
		josh.getBooks().add(bookOne);
		bookOne.getAuthors().add(josh);

		authorJpaRepository.save(josh);
		bookJpaRepository.save(bookOne);

		Author eric = new Author("Eric", "Evans");
		Book booktwo = new Book("Domain Driven Design", "22374", "Harper Collins");
		josh.getBooks().add(booktwo);
		booktwo.getAuthors().add(eric);

		authorJpaRepository.save(eric);
		bookJpaRepository.save(booktwo);

	}

}
