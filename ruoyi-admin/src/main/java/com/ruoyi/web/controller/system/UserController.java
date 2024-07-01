package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.User;
import com.ruoyi.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        boolean result = userService.createUser(user);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "User created successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to create user", null));
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user) {
        user.setUserId(id);
        boolean result = userService.updateUser(user);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "User updated successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to update user", null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        boolean result = userService.deleteUserById(id);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "User deleted successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to delete user", null));
        }
    }
}
