package com.sparta.hanghaetest.dto;

import com.sparta.hanghaetest.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private String name;
    private String email;
    private Long id;

    public MemberResponseDto(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.id = member.getId();

    }
}
