package shop.mtcoding.blogexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/40x")
    public String error() {

        return "/error/ex40x";
    }
}
