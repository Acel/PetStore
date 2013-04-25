package no.finn.petstore4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        AnimalTypes.addSomeRandomAnimals();
        AnimalsList.addSomeRandomAnimals();

        //Connector.createTables();
        //Connector.insertAnimalsList();

        model.addAttribute("message", "Hello world!");
		return "hello";
	}
}