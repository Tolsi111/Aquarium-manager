package springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Animal;
import springdemo.service.AnimalService;
import springdemo.util.SortUtils;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	///inject AnimalService
	@Autowired
	private AnimalService animalService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel, @RequestParam(required=false) String sort) {
		// get customers from the service
		List<Animal> theAnimals = null;
				
		// check for sort field
		if (sort != null) {
			int theSortField = Integer.parseInt(sort);
			theAnimals = animalService.getAnimals(theSortField);			
		}
		else {
		// no sort field provided ... default to sorting by last name
			theAnimals = animalService.getAnimals(SortUtils.NAME);
		}
				
		// add the customers to the model
		theModel.addAttribute("animals", theAnimals);
				
		return "list-animals";
	}
	
	@GetMapping("/showAddAnimalForm")
	public String showAddAnimalForm(Model theModel) {
		///create a new model attribute to bind form data
		Animal theAnimal = new Animal();
		
		theModel.addAttribute("animal", theAnimal);
		
		
		return "add-animal-form";
	}
	
	@PostMapping("/saveAnimal")
	public String saveCustomer(@ModelAttribute("animal") Animal theAnimal) {
		
		///save the animal using AnimalService
		animalService.saveAnimal(theAnimal);
		
		return "redirect:/animal/list";
	}
	
	@GetMapping("/showUpdateAnimalForm")
	public String showUpdateAnimalForm(@RequestParam("animalId") int theId, Model theModel) {
		///get animal from service
		Animal theAnimal = animalService.getAnimal(theId);
		
		///set the animal as a model attribute to prepopulate the form
		theModel.addAttribute("animal",theAnimal);///name, value
		
		///send over to form
		return "add-animal-form";		
	}
	
	@GetMapping("/deleteAnimal")
	public String deleteAnimal(@RequestParam("animalId") int theId) {
		
		animalService.deleteAnimal(theId);
		
		return "redirect:/animal/list";
	}
	
	@GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        // search customers from the service
        List<Animal> theAnimals = animalService.searchAnimals(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("animals", theAnimals);
        
        return "list-animals";        
    }
}
