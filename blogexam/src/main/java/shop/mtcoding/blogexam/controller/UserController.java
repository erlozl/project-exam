package shop.mtcoding.blogexam.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blogexam.dto.JoinDTO;
import shop.mtcoding.blogexam.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @PostMapping("/join")
    public String join(JoinDTO joinDto) {
        if (joinDto.getUsername() == null || joinDto.getUsername().isEmpty()) {
            return "redirect:/40x";
        }
        if (joinDto.getPassword() == null || joinDto.getPassword().isEmpty()) {
            return "redirect:/40x";
        }
        if (joinDto.getEmail() == null || joinDto.getEmail().isEmpty()) {
            return "redirect:/40x";
        }

        userRepository.save(joinDto);
        return "redirect:/loginForm";
    }
}
