package Thivi.Project.Gobi.Dreams.controller;

import Thivi.Project.Gobi.Dreams.dto.RegistrationDTO;
import Thivi.Project.Gobi.Dreams.dto.UserDTO;
import Thivi.Project.Gobi.Dreams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody RegistrationDTO registrationDTO) {
        return userService.registerUser(registrationDTO);
    }

    @GetMapping("/list")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
