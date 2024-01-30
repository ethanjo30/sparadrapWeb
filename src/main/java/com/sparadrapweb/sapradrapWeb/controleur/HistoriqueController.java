package com.sparadrapweb.sapradrapWeb.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrapweb.sapradrapWeb.model.Historique;
import com.sparadrapweb.sapradrapWeb.model.Ordonance;
import com.sparadrapweb.sapradrapWeb.repository.HistoriqueRepo;
import com.sparadrapweb.sapradrapWeb.repository.OrdonanceRepo;

import lombok.Data;

@Data
@Controller
public class HistoriqueController {

    @Autowired
    private HistoriqueRepo historiqueRepo;
	@Autowired
	private OrdonanceRepo ordonanceRepo;

    @GetMapping("/Historique")
	public String home(Model model) {
			Iterable<Historique> listHistorique = historiqueRepo.findAll();
			model.addAttribute("historiques", listHistorique);
			Iterable<Ordonance> listOrdonance = ordonanceRepo.findAll();
			model.addAttribute("ordonances", listOrdonance);
			
		return "Historique/homeHistorique";
	}

	@PostMapping("/saveHistorique")
	public String saveHistorique(Historique historique, BindingResult resultat) {

		if(resultat.hasErrors()) {
			return "redirect:/SansOrdonance";
		}
		
		historiqueRepo.save(historique);
		return"redirect:/SansOrdonance";
	}
}
