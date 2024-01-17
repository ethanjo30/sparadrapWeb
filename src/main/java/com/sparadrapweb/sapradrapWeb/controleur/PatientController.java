package com.sparadrapweb.sapradrapWeb.controleur;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sparadrapweb.sapradrapWeb.model.Mutuelle;
import com.sparadrapweb.sapradrapWeb.model.Patient;
import com.sparadrapweb.sapradrapWeb.repository.AdresseRepo;
import com.sparadrapweb.sapradrapWeb.repository.MutuelleRepo;
import com.sparadrapweb.sapradrapWeb.repository.PatientRepo;
import com.sparadrapweb.sapradrapWeb.repository.PersonneRepo;

import lombok.Data;


@Data
@Controller
public class PatientController {
    
    @Autowired
	private PatientRepo patientRepo;
	@Autowired
	private PersonneRepo personneREPO;
	@Autowired
	private AdresseRepo adresseREPO;
	@Autowired
	private MutuelleRepo mutuelleREPO;

	
	@GetMapping("/Patient")
	public String home(Model model) {
			Iterable<Patient> listPatient = patientRepo.findAll();
			model.addAttribute("patients", listPatient);
		return "Patient/homePatient";
	}
	
	@GetMapping("/createPatient")
	public String createPatient(Model model) {
		Patient e = new Patient();
		model.addAttribute("patient", e);
		Iterable<Mutuelle> mut = mutuelleREPO.findAll();
		model.addAttribute("mutuelles", mut);
		return "Patient/formNewPatient";
	}

	@GetMapping("/updatePatient/{id}")
	public String updatePatient(@PathVariable("id") final Integer id, Model model) {
		Optional<Patient> e = patientRepo.findById(id);		
		e.ifPresent(value ->model.addAttribute("patient", value));

		Iterable<Mutuelle> mut = mutuelleREPO.findAll();
		model.addAttribute("mutuelles", mut);
		return "Patient/formUpdatePatient";
	}
	
	@GetMapping("/deletePatient/{id}")
	public ModelAndView deletePatient(@PathVariable("id") final Integer id) {
		patientRepo.deleteById(id);
		return new ModelAndView("redirect:/Patient");		
	}
	
	@Transactional
	@PostMapping("/savePatient")
	public String savePatient(Patient patient, BindingResult resultat) {

		if(resultat.hasErrors()) {
			return "Patient/formUpdatePatient";
		}

		adresseREPO.save(patient.personne.adresse);
		personneREPO.save(patient.personne);
		patientRepo.save(patient);
		return"redirect:/Patient";
	}
}
