package com.phucle.flowerShopBE.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo.None;
import com.phucle.flowerShopBE.service.UserService;
import com.phucle.flowerShopBE.Utils.JwtUtil;
import com.phucle.flowerShopBE.model.User;
import com.phucle.flowerShopBE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseCookie.ResponseCookieBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");
        String token = userService.login(email, password);
        Map<String, Object> body = new HashMap<>();
        if (token != null) {
        	body.put("state", true);
        	ResponseCookie cookie = ResponseCookie.from("jwt", token).httpOnly(true).secure(false).path("/").sameSite("None").maxAge(7 * 24 * 60 * 60).build();
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(body);
        } else {
        	body.put("state", false);
        	body.put("message", "Invalid email or password");
            return ResponseEntity.status(401).body(body);
        }
    }
    
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@CookieValue(name = "jwt") String token) {
        if (token == null || !jwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("Invalid or missing token");
        }
        
        String email = jwtUtil.getEmailFromToken(token);
        Optional<User> user = userService.getUserByEmail(email);
        
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}
