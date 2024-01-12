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

import com.sparadrapweb.sapradrapWeb.model.Medicament;
import com.sparadrapweb.sapradrapWeb.repository.MedicamentRepo;

import lombok.Data;

@Data
@Controller
public class MedicamentController {
    
    @Autowired
	private MedicamentRepo service;
	
	@GetMapping("/Medicament")
	public String home(Model model) {
		Iterable<Medicament> listMedicament = service.findAll();
		model.addAttribute("medicament", listMedicament);
		return "Medicament/homeMedicament";
	}
	
	@GetMapping("/createMedicament")
	public String createMedicament(Model model) {
		Medicament e = new Medicament();
		model.addAttribute("medicament", e);
		return "Medicament/formNewMedicament";
	}
	
	@GetMapping("/updateMedicament/{id}")
	public String updateMedicament(@PathVariable("id") final Integer id, Model model) {
		Optional<Medicament> e = service.findById(id);		
		e.ifPresent(value ->model.addAttribute("medicament", value));	
		return "Medicament/formUpdateMedicament";		
	}
	
	@GetMapping("/deleteMedicament/{id}")
	public ModelAndView deleteMedicament(@PathVariable("id") final Integer id) {
		service.deleteById(id);
		return new ModelAndView("redirect:/Medicament");		
	}
	
	@PostMapping("/saveMedicament")
	public String saveMedicament(Medicament medicament, BindingResult resultat) {
		if(resultat.hasErrors()) {
			return "Medicament/formUpdateMedicament";
		}
		service.save(medicament);
		System.out.println(medicament);
		return"redirect:/Medicament";
	}

}
