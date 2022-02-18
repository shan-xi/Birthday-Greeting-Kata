package com.line.birthdaygreetingkata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;


/**
 * Data model mapping for Mongodb
 */
@Data
@Document(value = "member")
@AllArgsConstructor
@NoArgsConstructor
public class Member2 {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String gender;
    private Date birthday;
    private String email;
}