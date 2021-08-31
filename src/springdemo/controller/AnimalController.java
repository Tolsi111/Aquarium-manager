package springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springdemo.entity.Animal;
import springdemo.service.AnimalService;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	///inject AnimalService
	@Autowired
	private AnimalService animalService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		///get animals from dao
		List<Animal> theAnimals = animalService.getAnimals();
		
		///add animals to the model
		theModel.addAttribute("animals",theAnimals);
		
		return "list-animals";
	}
}
