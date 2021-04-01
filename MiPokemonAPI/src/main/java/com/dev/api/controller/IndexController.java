package com.dev.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para responder peticiones web 
 * @author LINESOFT
 *
 */
@Controller
public class IndexController {

	/**
	 * Controlador que redirecciona a la página principal de esta API
	 * @return Vista Index.html  
	 */
	@GetMapping("/help")
	public String help() {
		return "Index";
	}

}
