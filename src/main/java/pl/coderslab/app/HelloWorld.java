package pl.coderslab.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.ConstructorResult;

@Controller
public class HelloWorld {


    @GetMapping("/hello")
    public String helloWorld(){

        return "hello";
    }
}
