package com.example.sample1app.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sample1app.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
  public Optional<Person> findById(Long name);
}