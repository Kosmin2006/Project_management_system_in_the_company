package ua.opnu.management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.opnu.management_system.project.Employee;
import ua.opnu.management_system.project.Team;
import ua.opnu.management_system.repository.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team addMember(Long teamId, Employee employee) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Команду не знайдено"));
        team.getMembers().add(employee);
        return teamRepository.save(team);
    }

    public Team removeMember(Long teamId, Employee employee) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Команду не знайдено"));
        team.getMembers().remove(employee);
        return teamRepository.save(team);
    }
}
