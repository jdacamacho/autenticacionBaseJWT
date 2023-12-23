package com.unicauca.security.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.security.Entity.User;

public interface UserRepository extends CrudRepository<User,Long>{
    Optional<User> findByUsername(String username);
}
