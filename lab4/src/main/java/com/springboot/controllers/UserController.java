package com.springboot.controllers;

import com.springboot.domain.User_;
import com.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/list")
    public String listUsers(Model model){
        model.addAttribute("users", userService.listAll());
        return "user/list";
    }

    @RequestMapping("/user/menu")
    public String menu(){
        return "user/menu";
    }

    @RequestMapping("/user/failure_message")
    public String failure(){
        return "user/failure_message";
    }

    @RequestMapping("/user/login")
    public String login(Model model){
        model.addAttribute("user", new User_());
        return "user/loginform";
    }

    @RequestMapping("/user/new")
    public String newUser(Model model){
        model.addAttribute("user", new User_());
        return "user/userform";
    }


    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String authUser(@Valid User_ user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "user/loginform";
        }

        if (userService.checkIfExists(user)) {
            return "redirect:/user/list";
        } else {
            return "redirect:/user/failure_message";
        }
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(@Valid User_ user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "Something went wrong <div><a href ='/user/menu'> Menu </a></div>";
        }

        if (userService.checkIfEmailIsReserved(user)) {
            return "<div>Sorry, such email is already taken</div> " +
                    "<div>Sign up again</div> " +
                    "<div><a href ='/user/new'> Sign up </a></div>";
        } else {
            User_ savedUser = userService.saveUser(user);
            return "<div>You are successfully registered in the system.</div> " +
                    "<div>Go to menu and login, if you want to see other users.</div>" +
                    "<div><a href ='/user/menu'> Menu </a></div>";
        }
    }
}

