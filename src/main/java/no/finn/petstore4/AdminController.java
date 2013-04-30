package no.finn.petstore4;

import no.finn.data.Connector2;
import no.finn.data.JDBConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 17/04/13
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private Connector2 connector2;

    @RequestMapping(method = RequestMethod.GET)
    public String admin(ModelMap map) {
        map.addAttribute("animal", new Animal());
        map.addAttribute("animalTypes",AnimalTypes.getTypes());
        return "admin";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(@Valid Animal animal, BindingResult result, ModelMap map) {

        if (result.hasErrors()) {
            map.addAttribute("animalTypes",AnimalTypes.getTypes());
            return "admin";
        }

        //AnimalsList.addAnimal(animal);
        //Connector.insertAnimal(animal);

        connector2.insertAnimal(animal);
        return "redirect:admin";
    }
}
