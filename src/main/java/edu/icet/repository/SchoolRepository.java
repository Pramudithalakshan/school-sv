package edu.icet.repository;

import edu.icet.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SchoolRepository extends JpaRepository<School, Integer> {
}
