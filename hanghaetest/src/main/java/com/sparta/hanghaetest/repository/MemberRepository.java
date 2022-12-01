package com.sparta.hanghaetest.repository;

import com.sparta.hanghaetest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByOrderByModifiedAtDesc();
//    List<Member> findAll();
}
