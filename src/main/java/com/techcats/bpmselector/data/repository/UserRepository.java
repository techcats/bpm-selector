package com.techcats.bpmselector.data.repository;

import com.techcats.bpmselector.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends MongoRepository<User, Integer> {

}
