package com.matthew_cloud.sampleapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        try {
            userRepository.save(u);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteUser(@RequestParam String name, @RequestParam String email) {
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        userRepository.delete(u);
        return "deleted";
    }

    @PostMapping(path = "/update")
    public @ResponseBody String updateUser(@RequestParam String oldName, @RequestParam String newName, @RequestParam String oldEmail, @RequestParam String newEmail){
        User old = new User();
        User newUser = new User();
        old.setEmail(oldEmail);
        old.setName(oldName);
        newUser.setEmail(newEmail);
        newUser.setName(newName);
        userRepository.delete(old);
        userRepository.save(newUser);
        return "updated";
    }
}
