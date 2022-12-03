package com.example.javatest.service;

import com.example.javatest.domain.Member;
import com.example.javatest.domain.Study;
import com.example.javatest.domain.repository.StudyRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudyService {

    private final MemberService memberService;

    private final StudyRepository studyRepository;

    public StudyService(MemberService memberService,
            StudyRepository studyRepository) {
        assert memberService != null;
        assert studyRepository != null;

        this.memberService = memberService;
        this.studyRepository = studyRepository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);

        study.setOwner(member.orElseThrow(
                () -> new IllegalArgumentException("Member doesn't exist for id : " + member)));

        memberService.notify(study);

        return studyRepository.save(study);
    }
}
