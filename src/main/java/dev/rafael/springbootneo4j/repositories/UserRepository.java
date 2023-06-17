package dev.rafael.springbootneo4j.repositories;

import dev.rafael.springbootneo4j.models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public interface UserRepository extends Neo4jRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
    }
