package com.backendportfolio.portfolio.Repository;

import com.backendportfolio.portfolio.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    Optional<Experience> findByRol(String rol);
    boolean existsByRol(String rol);
}
