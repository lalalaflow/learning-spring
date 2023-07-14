package dev.helloworld.springmvc.validation.itemservice.validation;

import dev.helloworld.springmvc.validation.itemservice.domain.item.Item;
import jakarta.validation.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class BeanValidationTest {

    @Test
    void beanValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Item item = new Item();
        item.setItemName(" ");
        item.setPrice(0);
        item.setQuantity(10000);

        Set<ConstraintViolation<Item>> validators = validator.validate(item);
        for (ConstraintViolation<Item> violation : validators) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }
    }
}
