package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/principal")
public class MainControllers {
	
	@GetMapping({"/inicio", "/home"})
	public String getIndex(Model model) {
		model.addAttribute("titulo", "Inicio");
		return "index";
	}
	
}
