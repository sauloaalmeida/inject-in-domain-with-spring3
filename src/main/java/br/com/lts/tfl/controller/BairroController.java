package br.com.lts.tfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="bairro")
public class BairroController {
	
	
	@RequestMapping(value="/helloteste",method=RequestMethod.GET)
	public String hello(Model model){
		
		model.addAttribute("msg", "Ola Meu camarada");
		
		return "hello";
		
	}

}
