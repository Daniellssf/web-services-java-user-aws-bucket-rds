package com.javaNuvem.tp3.repository;

import com.javaNuvem.tp3.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    public Person findByEmail(String email);
}

