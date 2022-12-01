package com.sparta.hanghaetest.service;

import com.sparta.hanghaetest.dto.MemberRequestDto;
import com.sparta.hanghaetest.dto.MemberResponseDto;
import com.sparta.hanghaetest.entity.Member;
import com.sparta.hanghaetest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto createMember(MemberRequestDto requestDto) {
        Member member = new Member(requestDto);
        memberRepository.save(member);
        return new MemberResponseDto(member);
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> getMemberList() {
        List<Member> memberList = memberRepository.findAllByOrderByModifiedAtDesc();
        List<MemberResponseDto> memberResponseDto = new ArrayList<>();
        for (Member member : memberList) {
            MemberResponseDto memberDto = new MemberResponseDto(member);
            memberResponseDto.add(memberDto);
        }
        return memberResponseDto;
    }

    @Transactional(readOnly = true)
    public MemberResponseDto getMemberInfo(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new NullPointerException("회원 상세 조회 실패")
        );
        return new MemberResponseDto(member);
    }
}
