package Thivi.Project.Gobi.Dreams.controller;

import Thivi.Project.Gobi.Dreams.dto.UserDTO;
import Thivi.Project.Gobi.Dreams.entity.Role;
import Thivi.Project.Gobi.Dreams.entity.User;
import Thivi.Project.Gobi.Dreams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserDTO>> getUsersByRole(@PathVariable String role) {
        try {
            Role userRole = Role.valueOf(role.toUpperCase()); // Convert String to Role ENUM
            List<UserDTO> users = userService.getUsersByRole(userRole);
            return ResponseEntity.ok(users);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // Return 400 if role is invalid
        }
    }
}
