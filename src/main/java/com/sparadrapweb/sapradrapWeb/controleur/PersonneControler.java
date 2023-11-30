package com.sparadrapweb.sapradrapWeb.controleur;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sparadrapweb.sapradrapWeb.model.Personne;
import com.sparadrapweb.sapradrapWeb.repository.PersonneProxy;

import lombok.Data;

@Data
@Controller
public class PersonneControler {
	
    @Autowired
	private PersonneProxy service;
	
	@GetMapping("/")
	public String home(Model model) {
		Iterable<Personne> listPersonne = service.findAll();
		model.addAttribute("personne", listPersonne);
		return "home";
	}
	
	@GetMapping("/createPersonne")
	public String createPersonne(Model model) {
		Personne e = new Personne();
		model.addAttribute("personne", e);
		return "formNewPersonne";
	}
	
	@GetMapping("/updatePersonne/{id}")
	public String updatePersonnee(@PathVariable("id") final Integer id, Model model) {
		Optional<Personne> e = service.findById(id);		
		model.addAttribute("personne", e);	
		return "formUpdatePersonne";		
	}
	
	@GetMapping("/deletePersonne/{id}")
	public ModelAndView deletePersonne(@PathVariable("id") final Integer id) {
		service.deleteById(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/savedPersonne")
	public String savePersonne(@ModelAttribute Personne personne, BindingResult resultat, Model model) {
		if(resultat.hasErrors()) {
			return "formNewPersonne";
		}
		service.save(personne);
		return"redirect:/";
	}
}
