package com.shopshop.dto;


import lombok.Getter;
import lombok.Setter;


// 회원 가입 화면으로 넘어오는 가입 정보
@Getter @Setter
public class MemberFormDto {
    
    private String name;
    
    private String email;
    
    private String password;
    
    private String address;
}
