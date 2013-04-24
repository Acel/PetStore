package no.finn.petstore4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 17/04/13
 * Time: 14:54
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class ListController {

    @RequestMapping(value = "/list")
    public String admin(ModelMap model) {

        model.addAttribute("list", AnimalsList.getList());

        //model.addAttribute("message", "Hello world!");
        return "list";
    }

}
