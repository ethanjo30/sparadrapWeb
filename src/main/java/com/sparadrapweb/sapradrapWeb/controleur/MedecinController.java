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

import com.sparadrapweb.sapradrapWeb.model.Medecin;
import com.sparadrapweb.sapradrapWeb.repository.MedecinRepo;


import lombok.Data;

@Data
@Controller
public class MedecinController {

    @Autowired
	private MedecinRepo service;
	
	@GetMapping("/Medecin")
	public String home(Model model) {
		Iterable<Medecin> listMedecin = service.findAll();
		model.addAttribute("medecin", listMedecin);
		return "Medecin/homeMedecin";
	}
	
	@GetMapping("/createMedecin")
	public String createMedecin(Model model) {
		Medecin e = new Medecin();
		model.addAttribute("medecin", e);
		return "Medecin/formNewmedecin";
	}
	
	@GetMapping("/updateMedecin/{id}")
	public String updateMedecin(@PathVariable("id") final Integer id, Model model) {
		Optional<Medecin> e = service.findById(id);		
		e.ifPresent(value ->model.addAttribute("medecin", value));	
		return "Medecin/formUpdateMedecin";		
	}
	
	@GetMapping("/deleteMedecin/{id}")
	public ModelAndView deleteMedecin(@PathVariable("id") final Integer id) {
		service.deleteById(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/savedMedecin/{id}")
	public String savedMedecin(@PathVariable("id")final Integer id, Medecin medecin, BindingResult resultat, Model model) {
		if(resultat.hasErrors()) {
			return "Medecin/formUpdateMedecin";
		}
		service.save(medecin);
		return"redirect:/";
	}
}