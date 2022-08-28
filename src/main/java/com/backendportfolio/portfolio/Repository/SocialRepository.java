package com.backendportfolio.portfolio.Repository;

import com.backendportfolio.portfolio.Entity.Social;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepository extends JpaRepository<Social, Integer> {
    Optional<Social> findBySocialName(String socialName);
    boolean existsBySocialName(String socialName);
}