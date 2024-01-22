package com.sparadrapweb.sapradrapWeb.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sparadrapweb.sapradrapWeb.model.Panier;
import com.sparadrapweb.sapradrapWeb.repository.PanierRepo;

import lombok.Data;

@Data
@Controller
public class panierController {
    
        @Autowired
	    private PanierRepo panierRepo;

    	@GetMapping("/Panier")
	public String home(Model model) {
			Iterable<Panier> listPanier = panierRepo.findAll();
			model.addAttribute("patients", listPanier);
			
		return "Patient/homePatient";
	}
}
