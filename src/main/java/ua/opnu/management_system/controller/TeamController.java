package ua.opnu.management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.management_system.project.Employee;
import ua.opnu.management_system.project.Team;
import ua.opnu.management_system.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // Додати команду
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return ResponseEntity.ok(teamService.create(team));
    }

    // Отримати всі команди
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAll());
    }

    // Додати учасника до команди
    @PostMapping("/{teamId}/members")
    public ResponseEntity<Team> addMemberToTeam(@PathVariable Long teamId, @RequestBody Employee employee) {
        return ResponseEntity.ok(teamService.addMember(teamId, employee));
    }

    // Видалити учасника з команди
    @DeleteMapping("/{teamId}/members/{employeeId}")
    public ResponseEntity<Team> removeMemberFromTeam(@PathVariable Long teamId, @PathVariable Long employeeId) {
        return ResponseEntity.ok(teamService.removeMember(teamId, employeeId));
    }
}
