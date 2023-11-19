package com.fahasa.RestController;

import com.fahasa.model.User;
import com.fahasa.service.UserService;

import lombok.RequiredArgsConstructor;



import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
	
	
    @GetMapping
    public ResponseEntity<User> getUser() {
        // Lấy thông tin người dùng hiện tại từ Spring Security
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Trả về thông tin người dùng
        return ResponseEntity.ok(user);
    }
    
    
    
    
}
