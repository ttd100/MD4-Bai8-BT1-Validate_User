package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.academy.model.User;
import rikkei.academy.service.IUserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private IUserService userService;
    @ModelAttribute("userList")
    public Iterable<User> findAll(){
        return userService.findAll();
    }
    @GetMapping
    public  String showList(Model model){
        model.addAttribute("userForm", new User());
        return "/index";
    }
    @PostMapping
    public String save(
            @Valid
            @ModelAttribute("userForm")
            User user,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            return "/index";
        }
        else {
            userService.save(user);
            return "redirect:/";
        }
    }
}
