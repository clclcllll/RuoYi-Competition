package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.User;
import com.ruoyi.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            String token = "generated-jwt-token"; // 实现生成 JWT 的逻辑
            return ResponseEntity.ok(new ApiResponse(200, "Login successful", new TokenData(token)));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(401, "Invalid username or password", null));
        }
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        boolean result = userService.changePassword(changePasswordRequest.getUsername(), changePasswordRequest.getOldPassword(), changePasswordRequest.getNewPassword());
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Password changed successfully", null));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(400, "Failed to change password", null));
        }
    }
    //
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        boolean result = userService.register(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getRole(), registerRequest.getName(), registerRequest.getContactInfo());
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "User registered successfully", null));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(400, "Failed to register user", null));
        }
    }

}
class RegisterRequest {
    private String username;
    private String password;
    private String role;
    private String name;
    private String contactInfo;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    // Getters and setters
}
class LoginRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Getters and setters
}

class ChangePasswordRequest {
    private String username;
    private String oldPassword;
    private String newPassword;

    public String getUsername() {
        return username;
    }

    public String getOldPassword() {
        return oldPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }

    // Getters and setters
}

class ApiResponse {
    private int code;
    private String message;
    private TokenData data;

    public ApiResponse(int i, String loginSuccessful, TokenData tokenData) {
        this.code = i;
        this.message = loginSuccessful;
        this.data = tokenData;

    }

    // Getters and setters
}

class TokenData {
    private String token;

    public TokenData(String token) {
        this.token = token;
    }

    // Getters and setters
}
