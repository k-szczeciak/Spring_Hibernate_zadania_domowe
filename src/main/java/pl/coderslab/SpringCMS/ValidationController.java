package pl.coderslab.SpringCMS;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    private Validator validator;

    @GetMapping("/Validate")
    public String CategoryValidator(){
        Category category = new Category();
        Set<ConstraintViolation<Category>> violations = validator.validate(category);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Category> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " ");
            }

        } else {
                // save object }

        }
        return "validateResult";
    }
}
