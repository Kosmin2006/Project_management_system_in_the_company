package ua.opnu.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.management_system.project.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
