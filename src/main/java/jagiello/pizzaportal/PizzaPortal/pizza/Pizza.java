package jagiello.pizzaportal.PizzaPortal.pizza;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Data
public class Pizza {
    private Long id;
    private Date createAt;
    @NonNull
    @Size(min=5,message = "Please type min 5-char name.")
    private String name;
    @Size(min = 1,message = "Please choose at least 1 ingredients.")
    private List<Ingredient> ingredients;

    public Pizza() {
    }
}
