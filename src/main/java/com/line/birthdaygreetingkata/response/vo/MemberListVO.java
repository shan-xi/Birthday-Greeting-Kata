package com.line.birthdaygreetingkata.response.vo;

import com.line.birthdaygreetingkata.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Member List View Object
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class MemberListVO {
    private List<Member> members;
}
