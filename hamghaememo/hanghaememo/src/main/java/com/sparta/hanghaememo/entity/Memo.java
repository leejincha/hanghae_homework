package com.sparta.hanghaememo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.hanghaememo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor

public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;
    @JsonIgnore
    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private String title;


    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }

    public void update(MemoRequestDto memoRequestDto) {
        this.username = memoRequestDto.getUsername();
        this.contents = memoRequestDto.getContents();
        this.title = memoRequestDto.getTitle();
        this.password = memoRequestDto.getPassword();

    }
}