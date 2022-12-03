package com.example.javatest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.example.javatest.domain.Member;
import com.example.javatest.domain.Study;
import com.example.javatest.domain.repository.StudyRepository;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@ExtendWith(MockitoExtension.class)
@Testcontainers
class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Container
    static JdbcDatabaseContainer mariaDBContainer = new MariaDBContainer("mariadb:10.5")
            .withDatabaseName("test");

    @BeforeAll
    static void beforeAll() {
        mariaDBContainer.start();
    }

    @AfterAll
    static void afterAll() {
        mariaDBContainer.stop();
    }

    @Test
    void createStudyService() {
        // MockitoExtension 추가하여 @Mock 으로 대체 가능
//        MemberService memberService = mock(MemberService.class);
//        StudyRepository studyRepository = mock(StudyRepository.class);

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = Member.builder()
                .id(1L)
                .name("hyuk")
                .build();

        when(memberService.findById(any())).thenReturn(Optional.of(member));

        Study study = Study.builder()
                .limit(10)
                .name("java")
                .build();

        studyService.createNewStudy(1L, study);
    }

    @Test
    @DisplayName("")
    void ExcetionShouldbeThrown() {
        StudyService studyService = new StudyService(memberService, studyRepository);

        // 값이 리턴 되는 경우
        when(memberService.findById(1L)).thenThrow(new RuntimeException());

        Study study = Study.builder()
                .limit(10)
                .name("java")
                .build();

        assertThrows(RuntimeException.class, () -> studyService.createNewStudy(1L, study));

        // void 메서드 Throw Stubbing
        doThrow(new RuntimeException()).when(memberService).validate(1L);

        assertThrows(RuntimeException.class, () -> memberService.validate(1L));
    }

    @Test
    @DisplayName("")
    void multiResponse() {
        Member member = Member.builder()
                .id(1L)
                .name("hyuk")
                .build();

        // 여러 호출 리턴 되는 경우
        when(memberService.findById(any()))
                .thenReturn(Optional.of(member))
                .thenThrow(new IllegalArgumentException())
                .thenReturn(Optional.empty());

        Optional<Member> memberById = memberService.findById(1L);

        assertEquals("hyuk", memberById.get().getName());
        assertThrows(IllegalArgumentException.class, () -> memberService.findById(2L));
        assertEquals(Optional.empty(), memberService.findById(1L));
    }

    @Test
    void verifyTest() {
        // given
        Study study = Study.builder()
                .limit(10)
                .name("java")
                .build();

        Member member = Member.builder()
                .id(1L)
                .name("hyuk")
                .build();

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

//        when(memberService.findById(1L)).thenReturn(Optional.of(member));
//        when(studyRepository.save(study)).thenReturn(study);
        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        // when
        studyService.createNewStudy(1L, study);

        // then
        assertEquals(member, study.getOwner());

//        verify(memberService, times(1)).notify(study);
//        verify(memberService, never()).click();
        then(memberService).should(times(1)).notify(study);
        then(memberService).should(never()).click();
    }
}
