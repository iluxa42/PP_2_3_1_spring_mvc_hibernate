package hibermvc.controller;

import hibermvc.entity.User;
import hibermvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

        if (userService.getAllUsers().isEmpty()) {
            userService.saveUser(new User("Ivan", "Ivanov", 35, 1200, "ivanovich81@gmail.com"));
            userService.saveUser(new User("Victor", "Petrov", 22, 950, "petrovich3000@mail.ru"));
            userService.saveUser(new User("Софья", "Риановна", 43, 1030, "sophico11@yahoo.com"));
            userService.saveUser(new User("Sidr", "Sidorov", 31, 870, "sidr.sidr@list.ru"));
            userService.saveUser(new User("Петр", "Лебедев", 39, 720, "lebed.white@yahoo.com"));
        }
    }

    @RequestMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}