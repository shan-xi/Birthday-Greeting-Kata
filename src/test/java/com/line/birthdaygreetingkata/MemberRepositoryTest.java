package com.line.birthdaygreetingkata;

import com.line.birthdaygreetingkata.entity.Member;
import com.line.birthdaygreetingkata.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void init() {
        Member m1 = new Member("Robert", "Yen", "Male", "1975/8/8", "robert.yen@linecorp.com");
        Member m2 = new Member("Cid", "Change", "Male", "1990/10/10", "cid.change@linecorp.com");
        Member m3 = new Member("Miki", "Lai", "Female", "1993/4/5", "miki.lai@linecorp.com");
        Member m4 = new Member("Sherry", "Chen", "Female", "1993/8/8", "sherry.lai@linecorp.com");
        Member m5 = new Member("Peter", "Wang", "Male", "1950/12/22", "peter.wang@linecorp.com");
        memberRepository.save(m1);
        memberRepository.save(m2);
        memberRepository.save(m3);
        memberRepository.save(m4);
        memberRepository.save(m5);
    }

    @AfterEach
    public void destroy_all() {
        memberRepository.deleteAll();
    }

    @Test
    public void find_all_success() {
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(5);
    }
}
