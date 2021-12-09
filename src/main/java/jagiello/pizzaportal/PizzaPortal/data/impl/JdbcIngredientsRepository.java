package jagiello.pizzaportal.PizzaPortal.data.impl;

import jagiello.pizzaportal.PizzaPortal.data.IngredientsRepository;
import jagiello.pizzaportal.PizzaPortal.pizza.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcIngredientsRepository implements IngredientsRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, name, type from Ingredients",
                this::mapRowToIngredients);
    }

    @Override
    public Ingredient findById(String id) {
        return jdbc.queryForObject("select id, name , type from Ingredients where id=?",
                this::mapRowToIngredients, id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }

    private Ingredient mapRowToIngredients(ResultSet resultSet, int i) throws SQLException {
        return new Ingredient(
                resultSet.getString("id"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type")));

    }
}
