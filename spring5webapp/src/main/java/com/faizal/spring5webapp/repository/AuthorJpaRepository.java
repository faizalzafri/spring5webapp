package com.faizal.spring5webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faizal.spring5webapp.model.Author;

public interface AuthorJpaRepository extends JpaRepository<Author, Long>{

}
