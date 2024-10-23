package com.zeotap.RuleEngine.repository;



import com.zeotap.RuleEngine.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
