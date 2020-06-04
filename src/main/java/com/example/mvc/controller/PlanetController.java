package com.example.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mvc.dao.PlanetRepository;
import com.example.mvc.model.Planet;

@Controller
@RequestMapping("/planet")
@CrossOrigin(origins="*")
public class PlanetController {
	
	private PlanetRepository planetRepo;
	
	public PlanetController() {}
	
	@Autowired
	public void setPlanetRepo(PlanetRepository planetRepo) {
		this.planetRepo = planetRepo;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Planet getPlanetbyId(@PathVariable("id") int id) {
		return planetRepo.getById(id);
	}
	
	@PostMapping("/create")
	public @ResponseBody String addPlanet(@RequestBody Planet insertPlanet) {
		planetRepo.insert(insertPlanet);
		return "Success";
	}

}
