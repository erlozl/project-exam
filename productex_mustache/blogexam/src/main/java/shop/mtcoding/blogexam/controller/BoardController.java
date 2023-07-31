package shop.mtcoding.blogexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({ "/", "board" })
    public String main() {
        return "index";
    }

    @GetMapping("/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/board/{id}")
    public String detail() {
        return "board/detail";
    }
}
