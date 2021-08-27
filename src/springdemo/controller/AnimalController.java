package springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		return "list-animals";
	}
}
