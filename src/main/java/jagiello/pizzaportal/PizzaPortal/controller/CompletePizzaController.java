package jagiello.pizzaportal.PizzaPortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompletePizzaController {

    @GetMapping("/chooseyourpizza")
    public String chooseYourPizza(){
        return "chooseYourPizza";
    }
}
