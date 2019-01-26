package com.faizal.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.faizal.spring5webapp.model.Author;
import com.faizal.spring5webapp.model.Book;
import com.faizal.spring5webapp.model.Publisher;
import com.faizal.spring5webapp.repository.AuthorJpaRepository;
import com.faizal.spring5webapp.repository.BookJpaRepository;
import com.faizal.spring5webapp.repository.PublisherJpaRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorJpaRepository authorJpaRepository;
	private BookJpaRepository bookJpaRepository;
	private PublisherJpaRepository publisherJpaRepository;

	public DevBootstrap(AuthorJpaRepository authorJpaRepository, BookJpaRepository bookJpaRepository,
			PublisherJpaRepository publisherJpaRepository) {
		super();
		this.authorJpaRepository = authorJpaRepository;
		this.publisherJpaRepository = publisherJpaRepository;
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
		Publisher publisherOne = new Publisher("Pivotal Inc.", "Dummy Address");
		Book bookOne = new Book("Spring Boot 101", "22334", publisherOne);
		josh.getBooks().add(bookOne);
		bookOne.getAuthors().add(josh);

		authorJpaRepository.save(josh);
		publisherJpaRepository.save(publisherOne);
		bookJpaRepository.save(bookOne);

		Author eric = new Author("Eric", "Evans");
		Publisher publisherTwo = new Publisher("Harper Collins", "Dummy Address 2");
		Book booktwo = new Book("Domain Driven Design", "22374", publisherTwo);
		josh.getBooks().add(booktwo);
		booktwo.getAuthors().add(eric);

		authorJpaRepository.save(eric);
		publisherJpaRepository.save(publisherTwo);
		bookJpaRepository.save(booktwo);

	}

}
