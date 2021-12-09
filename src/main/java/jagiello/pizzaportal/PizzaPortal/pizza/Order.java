package jagiello.pizzaportal.PizzaPortal.pizza;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.sql.Date;


@Data
public class Order {
    private Long id;
    private Date createAt;
    @NotBlank(message = "Typing name is needed.")
    private String name;
    @NotBlank(message = "Typing street is needed.")
    private String street;
    @NotBlank(message = "Typing city is needed.")
    private String city;
    @NotBlank(message = "Typing state is needed.")
    private String state;
    @NotBlank(message = "Typing zip-number is needed.")
    private String zip;
    @CreditCardNumber(message = "Incorrect Credit Card Number.")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Type in format : MM/RR.")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0,message = "Wrong CVV number.")
    private String ccCVV;

}
