package no.finn.petstore4;

import no.finn.data.Connector2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: javalons
 * Date: 07/05/13
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/myorders")
public class MyOrdersController {
    @Autowired
    private Connector2 connector2;

    @RequestMapping(method = RequestMethod.GET)
    public String admin(ModelMap model) {
        ArrayList list = connector2.getOrdersList();

        model.addAttribute("list", list);

        return "myorders";

    }

    @RequestMapping(method = RequestMethod.POST)
    public void processForm(@RequestParam int buttonvalue) {

        connector2.cancelOrder(buttonvalue);

    }
}
