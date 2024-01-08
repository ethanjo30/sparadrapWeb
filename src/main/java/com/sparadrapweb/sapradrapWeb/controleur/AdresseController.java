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

import com.sparadrapweb.sapradrapWeb.model.Adresse;
import com.sparadrapweb.sapradrapWeb.repository.AdresseRepo;

import lombok.Data;

@Data
@Controller
public class AdresseController {

    @Autowired
	private AdresseRepo service;
	
	@GetMapping("/Adresse")
	public String home(Model model) {
		Iterable<Adresse> listAdresse = service.findAll();
		model.addAttribute("adresse", listAdresse);
		return "Adresse/homeAdresse";
	}
	
	@GetMapping("/createAdresse")
	public String createAdresse(Model model) {
		Adresse e = new Adresse();
		model.addAttribute("adresse", e);
		return "Adresse/formNewAdresse";
	}
	
	@GetMapping("/updateAdresse/{id}")
	public String updateAdresse(@PathVariable("id") final Integer id, Model model) {
		Optional<Adresse> e = service.findById(id);		
		e.ifPresent(value ->model.addAttribute("adresse", value));	
		return "Adresse/formUpdateAdresse";		
	}
	
	@GetMapping("/deleteAdresse/{id}")
	public ModelAndView deleteAdresse(@PathVariable("id") final Integer id) {
		service.deleteById(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/savedAdresse/{id}")
	public String savedAdresse(@PathVariable("id")final Integer id, Adresse adresse, BindingResult resultat, Model model) {
		if(resultat.hasErrors()) {
			return "Adresse/formUpdateAdresse";
		}
		service.save(adresse);
		return"redirect:/";
	}
}
