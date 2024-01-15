package com.sparadrapweb.sapradrapWeb.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class connection {
      @GetMapping("/Connection")
    public String home(Model model) {
		return "Page/connection";
	}
}
