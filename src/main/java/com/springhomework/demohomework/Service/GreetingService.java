package com.springhomework.demohomework.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.springhomework.demohomework.Controller.Greeting;
import com.springhomework.demohomework.Repository.GreetingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    GreetingRepository repository;

    public List<Greeting> getAllGreetings() {
        List<Greeting> greetingList = repository.findAll();
        if (greetingList.size() > 0) {
            return greetingList;
        } else {
            return new ArrayList<Greeting>();
        }
    }

    public Greeting getGreetingById(Long id) {
        Optional<Greeting> greeting = repository.findById(id);
        if (greeting.isPresent()) {
            return greeting.get();
        }
        return greeting.get();
    }

    public Greeting createOrUpdateGreeting(Greeting entity) {
        Optional<Greeting> greeting = repository.findById(entity.getId());
        if (greeting.isPresent()) {
            Greeting newEntity = greeting.get();
            newEntity.setId(entity.getId());
            newEntity.setContent(entity.getContent());
            newEntity = repository.save(newEntity);
            return newEntity;
        } else {
            entity = repository.save(entity);
            return entity;
        }
    }
}