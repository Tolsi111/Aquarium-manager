package springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springdemo.dao.AnimalDAO;
import springdemo.entity.Animal;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	///inject animal dao
	@Autowired
	private AnimalDAO animalDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		///get animals from dao
		List<Animal> theAnimals = animalDAO.getAnimals();
		
		///add animals to the model
		theModel.addAttribute("animals",theAnimals);
		
		return "list-animals";
	}
}
