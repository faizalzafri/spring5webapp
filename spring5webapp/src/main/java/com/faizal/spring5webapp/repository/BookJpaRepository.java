package com.faizal.spring5webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faizal.spring5webapp.model.Book;

public interface BookJpaRepository extends JpaRepository<Book, Long> {

}
