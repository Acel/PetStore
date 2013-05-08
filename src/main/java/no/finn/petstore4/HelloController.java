package no.finn.petstore4;

import no.finn.data.Connector2;
import no.finn.data.JDBConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private Connector2 connector2;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        AnimalTypes.addSomeRandomAnimals();
        AnimalsList.addSomeRandomAnimals();

        connector2.init();

        model.addAttribute("message", "Hello world!");
		return "hello";
	}
}