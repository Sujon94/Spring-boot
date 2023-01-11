package com.example.crud.controller;

import com.example.crud.dto.UserDto;
import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        //TODO::
        UserDto userDto = new UserDto();

        model.addAttribute("user",userDto);
        return "register";
    }

    @PostMapping("/register/save")
    public String createUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        User userInfo = userRepository.findByEmail(userDto.getEmail());

        if (userInfo != null && !userInfo.getEmail().isEmpty()){
            result.rejectValue("email",null,"Email is already used.");
        }

        if (result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        try{
            User _user = new User();
            _user.setUserName(userDto.getName());
            _user.setEmail(userDto.getEmail());
            _user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(_user);

            redirectAttributes.addFlashAttribute("message","Congrats! You are registered.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message","Something went wrong.");
        }

        return "redirect:/register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
