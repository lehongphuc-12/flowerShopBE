package com.phucle.flowerShopBE.service;

import com.phucle.flowerShopBE.Utils.JwtUtil;
import com.phucle.flowerShopBE.model.User;
import com.phucle.flowerShopBE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private com.phucle.flowerShopBE.repository.RoleRepository roleRepository;
    
    public String login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            // In a real application, you should hash the password and compare it with the stored hash.
            if (user.getPasswordHash().equals(password)) {
                return jwtUtil.generateToken(user.getEmail(), user.getRole().getRoleId(),  user.getUserId());
            }
        }
        return null;
    }

    public User getUserProfile(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User register(com.phucle.flowerShopBE.DTO.RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setPhone(request.getPhoneNumer());
        user.setPasswordHash(request.getPassword()); // In real app, hash this!
        user.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));

        com.phucle.flowerShopBE.model.Role role = roleRepository.findByRoleName("USER")
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRole(role);

        return userRepository.save(user);
    }
}
