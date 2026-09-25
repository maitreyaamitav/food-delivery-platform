package org.fooddelivery.userservice.user.persistent.repository;

import java.util.Optional;

import org.fooddelivery.userservice.user.persistent.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
