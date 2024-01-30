package com.sparadrapweb.sapradrapWeb.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.sparadrapweb.sapradrapWeb.model.Contient;
import com.sparadrapweb.sapradrapWeb.model.Historique;
import com.sparadrapweb.sapradrapWeb.model.Medicament;
import com.sparadrapweb.sapradrapWeb.model.Ordonance;
import com.sparadrapweb.sapradrapWeb.model.Patient;
import com.sparadrapweb.sapradrapWeb.repository.ContientRepo;
import com.sparadrapweb.sapradrapWeb.repository.MedicamentRepo;
import com.sparadrapweb.sapradrapWeb.repository.OrdonanceRepo;
import com.sparadrapweb.sapradrapWeb.repository.PatientRepo;

import lombok.Data;

@Data
@Controller
public class OrdonanceController {
    
	@Autowired
	private OrdonanceRepo ordonancerepo;
	@Autowired
	private ContientRepo contientRepo;
	@Autowired
	private PatientRepo patientRepo;
	@Autowired
	private MedicamentRepo medicamentRepo;


	@GetMapping("/AvecOrdonance")
	public String home(Model model) {
		Iterable<Ordonance> listOrdonance = ordonancerepo.findAll();
		model.addAttribute("ordonances", listOrdonance);
		Iterable<Contient> listContient = contientRepo.findAll();
	    model.addAttribute("contients", listContient);
		Iterable<Patient> listPatient = patientRepo.findAll();
	    model.addAttribute("patients", listPatient);

	return "Achat/homeAvecOrdonance";
	}

	@GetMapping("/SansOrdonance")
	public String homes(Model model) {
		Iterable<Ordonance> listOrdonance = ordonancerepo.findAll();
		model.addAttribute("ordonances", listOrdonance);
		Iterable<Contient> listContient = contientRepo.findAll();
	    model.addAttribute("contients", listContient);
		Iterable<Medicament> listMedicament = medicamentRepo.findAll();
	    model.addAttribute("medicaments", listMedicament);
		Iterable<Patient> listPatient = patientRepo.findAll();
	    model.addAttribute("patients", listPatient);
		Historique historique = new Historique();
		model.addAttribute("historique", historique);
	return "Achat/homeSansOrdonance";
	}
}
