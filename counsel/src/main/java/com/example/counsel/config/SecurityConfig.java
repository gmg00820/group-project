package com.example.counsel.config;

import com.example.counsel.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
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
            ROLE_ADMIN > ROLE_C
            ROLE_C > ROLE_B
            ROLE_B > ROLE_A
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
                .roles("A") // 일반 사용자 권한
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    // 시큐리티 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // URL 접근 권한 설정
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/login", "/join", "/joinProc", "/oauth2/**", "/reset-password", "/css/**", "/js/**","/admin/login").permitAll()
                        .requestMatchers("/admin/**","admin/admin-main").hasRole("ADMIN") // 관리자 페이지 접근 권한 설정
                        .requestMatchers("/").authenticated()          // 메인 페이지는 인증된 사용자만 접근 가능
                        .anyRequest().authenticated()
                )

                // 일반 로그인 설정
                .formLogin((auth) -> auth
                        .loginPage("/login")              // 사용자 정의 로그인 페이지
                        .loginProcessingUrl("/loginProc") // 로그인 처리 URL
                        .defaultSuccessUrl("/", true)     // 로그인 성공 시 메인 페이지로 이동
                        .permitAll()
                )


                // OAuth2 로그인 설정
                .oauth2Login((oauth2) -> oauth2
                        .loginPage("/login")  // 소셜 로그인 페이지
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService) // 사용자 서비스 설정
                        )
                )

                // 로그아웃 설정
                .logout((auth) -> auth
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )

                // CSRF 비활성화
                .csrf((auth) -> auth.disable())

                // HTTP Basic 비활성화
                .httpBasic(Customizer.withDefaults())

                // 세션 관리 설정
                .sessionManagement((auth) -> auth
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true)
                )
                .sessionManagement((auth) -> auth
                        .sessionFixation().changeSessionId()
                );

        return http.build();
    }
}
