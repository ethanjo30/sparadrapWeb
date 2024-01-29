package com.sparadrapweb.sapradrapWeb.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrapweb.sapradrapWeb.model.Historique;
import com.sparadrapweb.sapradrapWeb.repository.HistoriqueRepo;

import lombok.Data;

@Data
@Controller
public class HistoriqueController {

    @Autowired
    private HistoriqueRepo historiqueRepo;

    @GetMapping("/Historique")
	public String home(Model model) {
			Iterable<Historique> listHistorique = historiqueRepo.findAll();
			model.addAttribute("historiques", listHistorique);
			
		return "Historique/homeHistorique";
	}

	@PostMapping("/saveHistorique")
	public String saveHistorique(Historique historique, BindingResult resultat) {

		if(resultat.hasErrors()) {
			return "Achat/homeSansOrdonance";
		}
		
		historiqueRepo.save(historique);
		return"Achat/homeSansOrdonance";
	}
}
