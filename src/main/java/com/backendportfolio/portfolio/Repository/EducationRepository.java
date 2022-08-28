package com.backendportfolio.portfolio.Repository;

import com.backendportfolio.portfolio.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
    Optional<Education> findByTitle(String title);
    boolean existsByTitle(String title);
}
