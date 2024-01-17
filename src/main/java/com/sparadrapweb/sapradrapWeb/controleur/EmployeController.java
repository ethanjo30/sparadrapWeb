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

import com.sparadrapweb.sapradrapWeb.model.Employe;
import com.sparadrapweb.sapradrapWeb.repository.AdresseRepo;
import com.sparadrapweb.sapradrapWeb.repository.EmployeRepo;
import com.sparadrapweb.sapradrapWeb.repository.PersonneRepo;

import lombok.Data;

@Data
@Controller
public class EmployeController {
    
    @Autowired
	private EmployeRepo employeRepo;
	@Autowired
	private PersonneRepo personneREPO;
    @Autowired
	private AdresseRepo adresseREPO;

    @GetMapping("/Employe")
	public String home(Model model) {
			Iterable<Employe> listEmploye = employeRepo.findAll();
			model.addAttribute("employe", listEmploye);
		return "Employe/homeEmploye";
	}
	
	@GetMapping("/createEmploye")
	public String createEmploye(Model model) {
		Employe e = new Employe();
		model.addAttribute("employe", e);
		return "Employe/formNewEmploye";
	}

	@GetMapping("/updateEmploye/{id}")
	public String updateEmployet(@PathVariable("id") final Integer id, Model model) {
		Optional<Employe> e = employeRepo.findById(id);		
		e.ifPresent(value ->model.addAttribute("employe", value));	
		return "Employe/homeEmploye";		
	}
	
	@GetMapping("/deleteEmploye/{id}")
	public ModelAndView deletePatient(@PathVariable("id") final Integer id) {
		employeRepo.deleteById(id);
		return new ModelAndView("redirect:/Employe");		
	}
	
	@Transactional
	@PostMapping("/saveEmploye")
	public String saveEmploye(Employe employe, BindingResult resultat) {

		if(resultat.hasErrors()) {
			return "Employe/formUpdateEmploye";
		}

		adresseREPO.save(employe.personne.adresse);
		personneREPO.save(employe.personne);
		employeRepo.save(employe);
		return"redirect:/Patient";
	}
}

