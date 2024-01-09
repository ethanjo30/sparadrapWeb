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
import com.sparadrapweb.sapradrapWeb.repository.AdresseRepo;
import com.sparadrapweb.sapradrapWeb.repository.PatientRepo;
import com.sparadrapweb.sapradrapWeb.repository.PersonneRepo;

import lombok.Data;

@Data
@Controller
public class PatientController {
    
    @Autowired
	private PatientRepo service;
	@Autowired
	private PersonneRepo personneREPO;
	@Autowired
	private AdresseRepo adresseREPO;
	
	@GetMapping("/Patient")
	public String home(Model model) {
			Iterable<Patient> listPatient = service.findAll();
			model.addAttribute("patients", listPatient);
		return "Patient/homePatient";
	}
	
	// faire un finall avec les mutuelle pour quelle les mutuelle 
	//soit proposer dans la combobox sans que nous on la modifie
	@GetMapping("/createPatient")
	public String createPatient(Model model) {
		Patient e = new Patient();
		model.addAttribute("patient", e);
		return "Patient/formNewPatient";
	}
	
	@GetMapping("/updatePatient/{id}")
	public String updatePatient(@PathVariable("id") final Integer id, Model model) {
		Optional<Patient> e = service.findById(id);		
		e.ifPresent(value ->model.addAttribute("patient", value));	
		return "Patient/formUpdatePatient";		
	}
	
	@GetMapping("/deletePatient/{id}")
	public ModelAndView deletePatient(@PathVariable("id") final Integer id) {
		service.deleteById(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/savePatient")
	public String savedPatient(Patient patient, BindingResult resultat) {
		if(resultat.hasErrors()) {
			System.out.println(resultat);
			return "Patient/formUpdatePatient";
		}
		
		try {
			System.out.println("Personne" + patient.personne.getNom_Personne());

			adresseREPO.save(patient.getPersonne().getAdresse());
			personneREPO.save(patient.getPersonne());
			service.save(patient);
		} catch (Exception e) {
			e.printStackTrace(); // mettre un logger 
			return "Patient/formUpdatePatient";
		}
		return"redirect:/Patient";
	}
}
