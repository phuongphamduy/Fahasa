package com.fahasa.RestController;

import com.fahasa.model.User;
import com.fahasa.reponsitory.UserRepository;
import com.fahasa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUser() {
        // Lấy thông tin người dùng hiện tại từ Spring Security
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Trả về thông tin người dùng
        return ResponseEntity.ok(user);
    }


}
