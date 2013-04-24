package no.finn.petstore4;

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
@SessionAttributes
//@RequestMapping(value = "/admin", method = RequestMethod.GET)
public class AdminController {
    /*@RequestMapping(value = "/admin")
    public String admin(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "admin";
    }

    @RequestMapping(value = "admin", method = RequestMethod.POST)
    public String processForm(@RequestParam(value="type") String type) {
        AnimalsList.addAnimal(new Animal(type, 12, "ddde"));
        return "admin";
    }*/

    @RequestMapping("/admin")
    public ModelAndView admin() {
        ModelMap map = new ModelMap("command", new Animal());
        map.addAttribute("animalTypes",AnimalTypes.getTypes());
        return new ModelAndView("admin", map);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("admin") @Valid Animal animal, BindingResult result) {
        AnimalsList.addAnimal(animal);

        if (result.hasErrors()) {
            return "admin";
        }
        //return new ModelAndView("admin", "command", new Animal());
        return "redirect:admin";
    }
}
