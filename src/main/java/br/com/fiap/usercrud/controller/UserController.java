package br.com.fiap.usercrud.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fiap.usercrud.entity.User;
import br.com.fiap.usercrud.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("userlist",userRepository.findAll());
        return "home";
    }

    @GetMapping("/saveUserPage")
    public String saveUserPage(Model model) {
        User user=new User();
        model.addAttribute("user",user);
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/updateUserPage/{id}")
    public String showUpdateUserPage(@PathVariable("id") int id, Model model) {
        Optional<User> temp=userRepository.findById(id);
        User user=temp.get();
        model.addAttribute("user",user);
        return "updateUser";
    }
    
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }

}
