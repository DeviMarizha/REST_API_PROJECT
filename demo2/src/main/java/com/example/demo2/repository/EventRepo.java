package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.model.Event;

public interface EventRepo extends JpaRepository<Event, Integer> {

}
