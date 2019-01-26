package com.faizal.spring5webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faizal.spring5webapp.model.Publisher;

public interface PublisherJpaRepository extends JpaRepository<Publisher, Long> {

}
