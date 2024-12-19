package com.example.counsel.config;

import com.example.counsel.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    // 비밀번호 암호화 설정
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 권한 계층 설정
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        hierarchy.setHierarchy("""
            ROLE_ADMIN > ROLE_USER
            """);
        return hierarchy;
    }

    // 테스트용 관리자 및 사용자 계정 설정
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin123")) // 관리자 비밀번호
                .roles("ADMIN") // 관리자 권한
                .build();

        UserDetails user = User.withUsername("user")
                .password(encoder.encode("user123")) // 사용자 비밀번호
                .roles("USER") // 일반 사용자 권한
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    // 일반 사용자용 Security 설정
    @Bean
    public SecurityFilterChain userSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/login/**", "/usermain/**") // 일반 유저 관련 URL 처리
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/loginProc").permitAll() // 로그인 관련 URL 허용
                        .anyRequest().hasRole("USER") // 유저 메인 페이지 접근은 USER 권한 필요
                )
                .formLogin(auth -> auth
                        .loginPage("/login")                 // 일반 유저 로그인 페이지
                        .loginProcessingUrl("/loginProc")    // 일반 유저 로그인 처리 URL
                        .defaultSuccessUrl("/usermain", true) // 로그인 성공 후 유저 메인 페이지로 이동
                        .permitAll()
                )
                .logout(auth -> auth
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable()); // 필요시 활성화 가능
        return http.build();
    }

    // 관리자용 Security 설정
    @Bean
    public SecurityFilterChain adminSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/admin/**") // 관리자 관련 URL 처리
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/login", "/admin/loginProc").permitAll() // 로그인 관련 URL 허용
                        .anyRequest().hasRole("ADMIN") // 관리자 메인 페이지 접근은 ADMIN 권한 필요
                )
                .formLogin(auth -> auth
                        .loginPage("/admin/login")            // 관리자 로그인 페이지
                        .loginProcessingUrl("/admin/loginProc") // 관리자 로그인 처리 URL
                        .defaultSuccessUrl("/adminmain", true) // 로그인 성공 후 관리자 메인 페이지로 이동
                        .permitAll()
                )
                .logout(auth -> auth
                        .logoutUrl("/admin/logout")
                        .logoutSuccessUrl("/admin/login")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable()); // 필요시 활성화 가능
        return http.build();
    }
}

