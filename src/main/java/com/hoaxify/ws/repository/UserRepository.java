package com.hoaxify.ws.repository;

import com.hoaxify.ws.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
