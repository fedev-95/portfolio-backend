package com.backendportfolio.portfolio.Repository;

import com.backendportfolio.portfolio.Entity.Profile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findByName(String name);
    boolean existsByName(String name);
}
