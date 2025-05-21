package ua.opnu.management_system.service;

import org.springframework.stereotype.Service;
import ua.opnu.management_system.project.Employee;
import ua.opnu.management_system.project.Team;
import ua.opnu.management_system.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team create(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Optional<Team> getById(Long id) {
        return teamRepository.findById(id);
    }

    public Team addMember(Long teamId, Employee employee) {
        Optional<Team> teamOpt = teamRepository.findById(teamId);
        if (teamOpt.isPresent()) {
            Team team = teamOpt.get();
            team.getMembers().add(employee);
            return teamRepository.save(team);
        } else {
            throw new RuntimeException("Team not found with id " + teamId);
        }
    }

    public Team removeMember(Long teamId, Long employeeId) {
        Optional<Team> teamOpt = teamRepository.findById(teamId);
        if (teamOpt.isPresent()) {
            Team team = teamOpt.get();
            team.getMembers().removeIf(member -> member.getId().equals(employeeId));
            return teamRepository.save(team);
        } else {
            throw new RuntimeException("Team not found with id " + teamId);
        }
    }
}
