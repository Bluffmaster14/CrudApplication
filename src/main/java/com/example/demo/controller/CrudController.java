package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Crud Operations")
public class CrudController {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping("/data/{aid}")
	public Optional<Alien> getDetails(@PathVariable int aid) {
	 	Optional<Alien> a = repo.findById(aid);
	 	return a;
	}
	
	@PostMapping("/data")
	public Alien addData(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@GetMapping("/data")
	public Iterable<Alien> getAllData() {
		Iterable<Alien> a= repo.findAll();
		return a;
	}
}
