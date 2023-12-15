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

import com.sparadrapweb.sapradrapWeb.model.Patient;
import com.sparadrapweb.sapradrapWeb.repository.PatientRepo;

import lombok.Data;

@Data
@Controller
public class PatientController {
    
    @Autowired
	private PatientRepo service;
	
	@GetMapping("/Patient")
	public String home(Model model) {
		Iterable<Patient> listPatient = service.findAll();
		model.addAttribute("patient", listPatient);
		return "patient/homePatient";
	}
	
	@GetMapping("/createPatient")
	public String createPatient(Model model) {
		Patient e = new Patient();
		model.addAttribute("patient", e);
		return "patient/formNewPatient";
	}
	
	@GetMapping("/updatePatient/{id}")
	public String updatePatient(@PathVariable("id") final Integer id, Model model) {
		Optional<Patient> e = service.findById(id);		
		e.ifPresent(value ->model.addAttribute("patient", value));	
		return "patient/formUpdatePatient";		
	}
	
	@GetMapping("/deletePatient/{id}")
	public ModelAndView deletePatient(@PathVariable("id") final Integer id) {
		service.deleteById(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/savedPatient/{id}")
	public String savedPatient(@PathVariable("id")final Integer id, Patient patient, BindingResult resultat, Model model) {
		if(resultat.hasErrors()) {
			return "patient/formUpdatePatient";
		}
		service.save(patient);
		return"redirect:/";
	}
}
