package com.sparadrapweb.sapradrapWeb.controleur;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sparadrapweb.sapradrapWeb.model.Personne;
import com.sparadrapweb.sapradrapWeb.repository.PersonneRepo;

import lombok.Data;

@Data
@Controller
public class PersonneController {

    @Autowired
	private PersonneRepo service;
	
	@GetMapping("/")
	public String home(Model model) {
		Iterable<Personne> listPersonne = service.findAll();
		model.addAttribute("personne", listPersonne);
		return "personne/homePersonne";
	}
	
	@GetMapping("/createPersonne")
	public String createPersonne(Model model) {
		Personne e = new Personne();
		model.addAttribute("personne", e);
		return "personne/formNewPersonne";
	}
	
	@GetMapping("/updatePersonne/{id}")
	public String updatePersonnee(@PathVariable("id") final Integer id, Model model) {
		Optional<Personne> e = service.findById(id);		
		e.ifPresent(value ->model.addAttribute("personne", value));	
		return "personne/formUpdatePersonne";		
	}
	
	@GetMapping("/deletePersonne/{id}")
	public ModelAndView deletePersonne(@PathVariable("id") final Integer id) {
		service.deleteById(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/savedPersonne/{id}")
	public String savedPersonne(@PathVariable("id")final Integer id, Personne personne, BindingResult resultat, Model model) {
		if(resultat.hasErrors()) {
			return "personne/formUpdatePersonne";
		}
		service.save(personne);
		return"redirect:/";
	}
}
