package com.nrt.consultancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrt.consultancy.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
