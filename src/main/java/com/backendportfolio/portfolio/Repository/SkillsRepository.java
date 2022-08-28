package com.backendportfolio.portfolio.Repository;

import com.backendportfolio.portfolio.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {
    Optional<Skills> findBySkillName(String skillName);
    boolean existsBySkillName(String skillName);
}
