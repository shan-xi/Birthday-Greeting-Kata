package com.line.birthdaygreetingkata.repository;

import com.line.birthdaygreetingkata.entity.Member2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Member Repository for Mongodb
 */
@Repository
public interface Member2Repository extends MongoRepository<Member2, String> {
    @Query("{ $expr: { '$and': [ { '$eq': [{ '$dayOfMonth': '$birthday' }, { '$dayOfMonth': ?0 }] }, { '$eq': [{ '$month': '$birthday' }, { '$month': ?0 }] }] } }")
    public Page<Member2> findMember2ByBirthday(Date birthday, Pageable pageable);
}
