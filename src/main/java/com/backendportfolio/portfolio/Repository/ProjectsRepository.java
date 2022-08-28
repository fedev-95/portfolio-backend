package com.backendportfolio.portfolio.Repository;

import com.backendportfolio.portfolio.Entity.Projects;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Integer> {
    Optional<Projects> findByTitle(String title);
    boolean existsByTitle(String title);
}
