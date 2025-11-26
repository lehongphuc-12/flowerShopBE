	package com.phucle.flowerShopBE.controller;


import com.phucle.flowerShopBE.service.UserService;



import com.phucle.flowerShopBE.Utils.JwtUtil;
import com.phucle.flowerShopBE.model.User;
import com.phucle.flowerShopBE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
        	ResponseCookie cookie = ResponseCookie.from("jwt", token).httpOnly(true).secure(true).path("/").sameSite("None").maxAge(7 * 24 * 60 * 60).build();
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(body);
        } else {
        	body.put("state", false);
        	body.put("message", "Invalid email or password");
            return ResponseEntity.status(401).body(body);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody com.phucle.flowerShopBE.DTO.RegisterRequest request) {
    	Map<String, Object> body = new HashMap<>();
        try {
            userService.register(request);
            body.put("state", true);
            body.put("message","User registered successfully" );
            String token = userService.login(request.getEmail(), request.getPassword());
            ResponseCookie cookie = ResponseCookie.from("jwt", token).httpOnly(true).secure(true).path("/").sameSite("None").maxAge(7 * 24 * 60 * 60).build();
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(body);
        } catch (RuntimeException e) {
        	body.put("state", false);
            body.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(body);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ResponseCookie cookie = ResponseCookie.from("jwt", "").httpOnly(true).secure(true).path("/").sameSite("None").maxAge(0).build();
        System.out.println("log out done");
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body("Logged out successfully");
    }
    
    @GetMapping("/logInStatus")
    public ResponseEntity<?> getLogInStatus(@CookieValue(name= "jwt", required = false) String token) {
    	Map<String, Object> bodyMap =  new HashMap<>();
    	if(token == null || token.trim().isEmpty()) {
    		bodyMap.put("status", false);
    	} else {
    		String nameString = jwtUtil.getEmailFromToken(token);
    		bodyMap.put("status", true);
    		bodyMap.put("fullName", nameString);
    	}
        return ResponseEntity.ok(bodyMap);
    }
    
    
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@CookieValue(name = "jwt", required = false) String token) {
        if (token == null || token.trim().isEmpty()) {
            return ResponseEntity.status(401).body("Invalid or missing token");
        }
        
        String email = jwtUtil.getEmailFromToken(token);
        Optional<User> user = userService.getUserByEmail(email);
        
        if (user.isPresent()) {
        	System.out.println(user.get());          
        	return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}
