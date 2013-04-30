package no.finn.petstore4;

import no.finn.data.Connector2;
import no.finn.data.JDBConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 17/04/13
 * Time: 14:54
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "/list")
public class ListController {
    @Autowired
    private Connector2 connector2;

    @RequestMapping(method = RequestMethod.GET)
    public String admin(ModelMap model) {
        //Connector2 connector2 = new JDBConnector();

        ArrayList list = connector2.getAnimalsList();

        //model.addAttribute("list", AnimalsList.getList());
        model.addAttribute("list", list);

        //model.addAttribute("message", "Hello world!");
        return "list";
    }

}
