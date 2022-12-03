package com.example.javatest.service;

import com.example.javatest.domain.Member;
import com.example.javatest.domain.Study;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MemberService {


    public Optional<Member> findById(Long memberId) {
        return null;
    }

    public void validate(Long memberId) {

    }

    void notify(Study newStudy) {

    }

    void click() {

    }
}
