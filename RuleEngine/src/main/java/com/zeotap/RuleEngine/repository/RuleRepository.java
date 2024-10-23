package com.zeotap.RuleEngine.repository;

import com.zeotap.RuleEngine.model.Rule; // Update the import to your correct package
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long> {
}
