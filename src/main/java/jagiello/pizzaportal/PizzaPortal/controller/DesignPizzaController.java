package jagiello.pizzaportal.PizzaPortal.controller;

import jagiello.pizzaportal.PizzaPortal.pizza.Ingredient;
import jagiello.pizzaportal.PizzaPortal.pizza.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jagiello.pizzaportal.PizzaPortal.pizza.Ingredient.Type;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignPizzaController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLOTO", "wheat", Type.WRAP),
                new Ingredient("COTO", "corn", Type.WRAP),
                new Ingredient("GRBF", "beef", Type.PROTEIN),
                new Ingredient("CARN", "meet", Type.PROTEIN),
                new Ingredient("TMTO", "tomatoe", Type.VEGGIES),
                new Ingredient("LETC", "lattuce", Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Type.CHEESE),
                new Ingredient("EDAM", "edam", Type.CHEESE),
                new Ingredient("SLSA", "salsa", Type.SAUCE),
                new Ingredient("SRCR", "cream", Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
      @GetMapping
      public String showDesignForm(Model model){
        model.addAttribute("design", new Pizza());
        return "design";
    }

    private Object filterByType(List<Ingredient> ingredients, Type type) {
    return ingredients
            .stream()
            .filter(x-> x.getType().equals(type))
            .collect(Collectors.toList());
        }

    @PostMapping
    public String processDesign(@Valid  @ModelAttribute("design") Pizza design, Errors errors){
        if(errors.hasErrors()){
            return "design";
        }

        log.info("Designing Pizza in progress");
        return "redirect:/orders/current";
    }
}
