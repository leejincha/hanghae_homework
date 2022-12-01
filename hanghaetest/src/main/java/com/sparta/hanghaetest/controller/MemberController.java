package com.sparta.hanghaetest.controller;

import com.sparta.hanghaetest.dto.MemberRequestDto;
import com.sparta.hanghaetest.dto.MemberResponseDto;
import com.sparta.hanghaetest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //POST는 테스트용입니다.
    @PostMapping("/member")
    public MemberResponseDto createMember(@RequestBody MemberRequestDto requestDto) {
        return memberService.createMember(requestDto);
    }

    @GetMapping("/member")
    public List<MemberResponseDto> getMemberList() {
        return memberService.getMemberList();
    }

    @GetMapping("/member/{id}")
    public MemberResponseDto getMemberInfo(@PathVariable Long id) {
        return memberService.getMemberInfo(id);
    }
}
