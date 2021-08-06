package dbweb.web.controller;

import dbweb.model.User;
import dbweb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "/all-users";
    }

    @GetMapping("user/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/user";
    }

    @GetMapping("/create-user")
    public String createUserForm(User user) {
        return "/create-user";
    }

    @PostMapping("/create-user")
    public String createUser(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("update-user/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/update-user";
    }

    @PatchMapping("/update-user")
    public String updateUser(User user) {
        userService.updateUser(user.getId(), user);
        return "redirect:/";
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


}
