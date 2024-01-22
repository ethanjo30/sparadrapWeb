package com.sparadrapweb.sapradrapWeb.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sparadrapweb.sapradrapWeb.model.Contient;

import com.sparadrapweb.sapradrapWeb.repository.ContientRepo;

public class ContientController {
    
    @Autowired
	private ContientRepo contientRepo;

    @GetMapping("/Contient")
	public String home(Model model) {
			Iterable<Contient> listContient = contientRepo.findAll();
			model.addAttribute("contients", listContient);
			
		return "Patient/homePatient";
	}
}
