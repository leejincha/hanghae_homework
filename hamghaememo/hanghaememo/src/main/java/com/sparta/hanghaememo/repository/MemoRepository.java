package com.sparta.hanghaememo.repository;


import com.sparta.hanghaememo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
//데이터베이스와 연결되는 것이 리포지토리! 소통한는 , <>안에 있는 테이블이랑 연결한다고 생각하면 된다.
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();

}