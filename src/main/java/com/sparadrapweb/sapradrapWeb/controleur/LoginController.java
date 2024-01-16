package com.sparadrapweb.sapradrapWeb.controleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @GetMapping("/User")
    public String getUser() {
        return "welcome, Employe";
    }
    
    @GetMapping("/Admin")
    public String getAdmin() {
        return "welcome, Admin";
    }
}
