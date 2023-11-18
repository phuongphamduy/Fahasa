package com.fahasa.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000")); // Đặt domain bạn muốn cho phép
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE")); // Cho phép các phương thức HTTP
        configuration.setAllowedHeaders(List.of("Origin", "Content-Type", "Accept", "Authorization")); // Cho phép các header
        configuration.setAllowCredentials(true); // Cho phép gửi cookie

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration); // Cấu hình CORS cho đường dẫn cụ thể
        source.registerCorsConfiguration("/**", configuration); // Cấu hình CORS cho tất cả các đường dẫn

        return source;
    }

    @Bean
    public CorsFilter corsFilter() {
        return new CorsFilter(corsConfigurationSource());
    }
}
