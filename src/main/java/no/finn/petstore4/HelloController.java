package no.finn.petstore4;

import no.finn.data.Connector2;
import no.finn.data.JDBConnector;
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

        Connector2 connector2 = new JDBConnector();
        connector2.init();

        model.addAttribute("message", "Hello world!");
		return "hello";
	}
}