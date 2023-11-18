package com.fahasa.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fahasa.model.User;
import com.fahasa.reponsitory.UserRepository;
import com.fahasa.service.EmailService;

import jakarta.servlet.http.HttpSession;
import lombok.experimental.PackagePrivate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/user")
public class ForgotPasswordController {
	Random random = new Random(1000);
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	
	@PostMapping("/forgot-password")
    public Map<String, String> sendOTP(@RequestParam("email") String email, HttpSession session) {
        Map<String, String> response = new HashMap<>();

        try {
            int otp = random.nextInt(999999);

            String subject = "OTP From Fahasa";
            String message = "Vui lòng không chia sẻ mã OTP này: " + "<h1>" + otp + "</h1>";
            String to = email;
            
            System.out.println("Email: " + email);
            System.out.println("Subject: " + subject);
            System.out.println("Message: " + message);

            boolean flag = this.emailService.sendEmail(subject, message, to);

            if (flag) {
                session.setAttribute("myotp", otp);
                session.setAttribute("email", email);
                response.put("status", "success");
                response.put("message", "Mã OTP đã được gửi đến địa chỉ email của bạn.");
            } else {
                response.put("status", "error");
                response.put("message", "Không thể gửi mã OTP. Vui lòng kiểm tra lại địa chỉ email của bạn.");
            }
         // Log phản hồi trả về cho client
            System.out.println("Phản hồi trả về cho client: " + response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "error");
            response.put("message", "Có lỗi xảy ra. Vui lòng thử lại sau.");
        }

        return response;
    }

    @PostMapping("/verify-otp")
    public Map<String, String> verifyOtp(@RequestParam("otp") String otp, HttpSession session) {
        Map<String, String> response = new HashMap<>();

        String myOtp = (String)session.getAttribute("myotp");
        String email = (String) session.getAttribute("email");

        if (myOtp.equals(otp)) {
            User user = this.userRepository.getUserByUserName(email);
            if (user == null) {
                response.put("status", "error");
                response.put("message", "Người dùng không tồn tại với email này!");
            } else {
                response.put("status", "success");
                response.put("message", "Mã OTP xác nhận thành công.");
            }
        } else {
            response.put("status", "error");
            response.put("message", "Bạn đã nhập sai OTP!");
        }

        return response;
    }

    @PostMapping("/change-password")
    public Map<String, String> changePassword(@RequestParam("newpassword") String newpassword, HttpSession session) {
        Map<String, String> response = new HashMap<>();

        String email = (String) session.getAttribute("email");
        User user = this.userRepository.getUserByUserName(email);

        if (user != null) {
            user.setPassword(this.bcrypt.encode(newpassword));
            this.userRepository.save(user);

            response.put("status", "success");
            response.put("message", "Mật khẩu đã được thay đổi thành công.");
        } else {
            response.put("status", "error");
            response.put("message", "Người dùng không tồn tại với email này!");
        }

        return response;
    }
}
