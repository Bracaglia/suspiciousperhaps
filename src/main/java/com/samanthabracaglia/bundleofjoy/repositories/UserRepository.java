package com.samanthabracaglia.bundleofjoy.repositories;

import com.samanthabracaglia.bundleofjoy.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
