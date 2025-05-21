package ua.opnu.management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.management_system.project.Employee;
import ua.opnu.management_system.project.Team;
import ua.opnu.management_system.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    // 17. Додати команду
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return ResponseEntity.ok(teamService.createTeam(team));
    }

    // 20. Отримати всі команди
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    // 18. Додати учасника до команди
    @PostMapping("/{teamId}/members")
    public ResponseEntity<Team> addMember(@PathVariable Long teamId, @RequestBody Employee employee) {
        return ResponseEntity.ok(teamService.addMember(teamId, employee));
    }

    // 19. Видалити учасника з команди
    @DeleteMapping("/{teamId}/members")
    public ResponseEntity<Team> removeMember(@PathVariable Long teamId, @RequestBody Employee employee) {
        return ResponseEntity.ok(teamService.removeMember(teamId, employee));
    }
}
