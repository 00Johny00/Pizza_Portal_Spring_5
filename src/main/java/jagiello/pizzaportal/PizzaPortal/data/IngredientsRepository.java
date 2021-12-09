package jagiello.pizzaportal.PizzaPortal.data;

import jagiello.pizzaportal.PizzaPortal.pizza.Ingredient;
import org.springframework.data.relational.core.sql.In;

public interface IngredientsRepository {
    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
