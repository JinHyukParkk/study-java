package org.example.two;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NameTest {
//    @DisplayName 쓰는게 명시적이고 보기 쉽기 때문에 이걸 추천.
    @Test
    void create_new_name() {
        Name name = new Name();
        assertNotNull(name);
    }

    @Test
    @DisplayName("스터디 만들기")
    void create_new_study() {
        Study study = new Study();
        assertNotNull(study);
    }
}
