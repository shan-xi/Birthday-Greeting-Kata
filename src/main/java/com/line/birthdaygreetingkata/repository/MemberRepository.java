package com.line.birthdaygreetingkata.repository;

import com.line.birthdaygreetingkata.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;

import static org.hibernate.jpa.QueryHints.HINT_COMMENT;

/**
 * Member Repository
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    @QueryHints(value = {@QueryHint(name = HINT_COMMENT, value = "a query for pageable")})
    @Query("SELECT m FROM Member m where DATE_FORMAT(STR_TO_DATE(m.birthday, '%Y/%m/%d'), '%m/%d') = :birthday")
    Page<Member> findByBirthday(@Param("birthday") String birthday, Pageable pageable);
}
