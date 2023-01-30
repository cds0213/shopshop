package com.shopshop.config;

import com.shopshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration

// WebSecurityConfigurerAdapter를 상속받아서 오버라이딩을 통해 보안 설정을 커스터마이징 할 수 있음.
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception { // http 요청에 대한 보안을 설정
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){ // 비밀번호를 데이터베이스에 그대로 저장했을 경우 해킹당했을 경우 그대로 노출
        // 해시 함수를 이용하여 비밀번호 암호화
        return new BCryptPasswordEncoder();
    }

  
}