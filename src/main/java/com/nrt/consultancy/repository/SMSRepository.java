package com.nrt.consultancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrt.consultancy.entities.SMS;

public interface SMSRepository extends JpaRepository<SMS, Long> {

}
