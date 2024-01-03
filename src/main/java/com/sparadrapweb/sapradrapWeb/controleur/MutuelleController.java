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

import com.sparadrapweb.sapradrapWeb.model.Mutuelle;
import com.sparadrapweb.sapradrapWeb.repository.MutuelleRepo;

import lombok.Data;

@Data
@Controller

public class MutuelleController {
    
    @Autowired
	private MutuelleRepo service;
	
	@GetMapping("/Mutuelle")
	public String home(Model model) {
		Iterable<Mutuelle> listMutuelle = service.findAll();
		model.addAttribute("mutuelle", listMutuelle);
		return "Mutuelle/homeMutuelle";
	}
	
	@GetMapping("/createMutuelle")
	public String createMutuelle(Model model) {
		Mutuelle e = new Mutuelle();
		model.addAttribute("mutuelle", e);
		return "Mutuelle/formNewMutuelle";
	}
	
	@GetMapping("/updateMutuelle/{id}")
	public String updateMutuelle(@PathVariable("id") final Integer id, Model model) {
		Optional<Mutuelle> e = service.findById(id);		
		e.ifPresent(value ->model.addAttribute("mutuelle", value));	
		return "Mutuelle/formUpdateMutuelle";		
	}
	
	@GetMapping("/deleteMutuelle/{id}")
	public ModelAndView deleteMutuelle(@PathVariable("id") final Integer id) {
		service.deleteById(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/savedMutuelle/{id}")
	public String savedMutuelle(@PathVariable("id")final Integer id, Mutuelle mutuelle, BindingResult resultat, Model model) {
		if(resultat.hasErrors()) {
			return "Mutuelle/formUpdateMutuelle";
		}
		service.save(mutuelle);
		return"redirect:/";
	}
}

