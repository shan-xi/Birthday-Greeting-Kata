package com.line.birthdaygreetingkata.entity;

import lombok.Data;

import javax.persistence.*;


/**
 * Data model mapping for Mysql
 */
@Data
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstname;
    private String lastname;
    private String gender;
    private String birthday;
    private String email;

    public Member() {
    }

    public Member(String firstname, String lastname, String gender, String birthday, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
    }
}