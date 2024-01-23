package com.sparadrapweb.sapradrapWeb.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sparadrapweb.sapradrapWeb.model.Contient;
import com.sparadrapweb.sapradrapWeb.model.Ordonance;
import com.sparadrapweb.sapradrapWeb.repository.ContientRepo;
import com.sparadrapweb.sapradrapWeb.repository.OrdonanceRepo;

import lombok.Data;

@Data
@Controller
public class OrdonanceController {
    
	@Autowired
	private OrdonanceRepo ordonancerepo;
	@Autowired
	private ContientRepo contientRepo;

	@GetMapping("/Ordonance")
	public String home(Model model) {
		Iterable<Ordonance> listOrdonance = ordonancerepo.findAll();
		model.addAttribute("ordonances", listOrdonance);
		 Iterable<Contient> listContient = contientRepo.findAll();
	    model.addAttribute("contients", listContient);
		
	return "Achat/homeAvecOrdonance";
	}

	
}
