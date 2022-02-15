package com.line.birthdaygreetingkata.repository;

import com.line.birthdaygreetingkata.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Member Repository
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
