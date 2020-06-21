package com.springhomework.demohomework.Repository;

import com.springhomework.demohomework.Controller.Greeting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
