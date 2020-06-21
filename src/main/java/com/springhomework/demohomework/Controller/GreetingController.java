package com.springhomework.demohomework.Controller;

import java.util.List;

import com.springhomework.demohomework.Service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {
    @Autowired
    GreetingService service;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        Greeting updated = service.createOrUpdateGreeting(greeting);
        System.out.println(greeting.toString());
        return "result";
    }

    @GetMapping("/greetingall")
    public ResponseEntity<List<Greeting>> getAllgreetings() {
        List<Greeting> list = service.getAllGreetings();
        return new ResponseEntity<List<Greeting>>(list, HttpStatus.OK);
    }
    // @PostMapping("/savedata")
    // public ResponseEntity<Greeting> createOrUpdateGreeting(Greeting greeting) {
    // Greeting updated = service.createOrUpdateGreeting(greeting);
    // return new ResponseEntity<Greeting>(updated, HttpStatus.OK);
    // }
}