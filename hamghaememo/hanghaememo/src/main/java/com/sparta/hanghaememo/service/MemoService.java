package com.sparta.hanghaememo.service;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.dto.MemoResponseDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository; //데이터베이스와 연결하기 위해 repository와 연결

    @Transactional
    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto); //저장할 테이블 한 줄 row를 생성한다고 생각하면 된다.
        memoRepository.save(memo);
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return memoResponseDto;
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> getListMemos() {
        List<Memo> memoList = memoRepository.findAllByOrderByModifiedAtDesc();
        List<MemoResponseDto> memoResponseDto = new ArrayList<>();
        for (Memo memo : memoList) {
            MemoResponseDto memoDto = new MemoResponseDto(memo);
            memoResponseDto.add(memoDto);
        }
        return memoResponseDto;
    }

    @Transactional(readOnly = true)
    public MemoResponseDto getMemo(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return memoResponseDto;
    }

    @Transactional
    public MemoResponseDto update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        if (requestDto.getPassword().equals(memo.getPassword())) {
            memo.update(requestDto);
            return memoResponseDto;
        } else {
            return memoResponseDto;
        }

    }

    @Transactional
    public Map<String, Object> deleteMemo(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        Map<String, Object> reponse = new HashMap<>();
        if (requestDto.getPassword().equals(memo.getPassword())) {
            memoRepository.deleteById(id);
            reponse.put("success",true);
            return reponse;
        } else {
            reponse.put("success",false);
            return reponse;
        }
    }
}
