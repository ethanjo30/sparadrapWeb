package com.sparadrapweb.sapradrapWeb.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sparadrapweb.sapradrapWeb.model.Achat;
import com.sparadrapweb.sapradrapWeb.repository.AchatRepo;
import com.sparadrapweb.sapradrapWeb.repository.OrdonanceRepo;
import com.sparadrapweb.sapradrapWeb.repository.PatientRepo;

import lombok.Data;

@Data
@Controller
public class AchatController {
    
    @Autowired
    private AchatRepo achatRepo;
    @Autowired
	private PatientRepo patientRepo;
    @Autowired
	private OrdonanceRepo ordonanceRepo;

    @GetMapping("/Achat")
	public String home(Model model) {
			Iterable<Achat> listAchat = achatRepo.findAll();
			model.addAttribute("achats", listAchat);
			
		return "Achat/homeAvecOrdonance";
	}
}
