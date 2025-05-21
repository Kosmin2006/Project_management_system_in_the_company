package ua.opnu.management_system.project;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;
    private String email;

    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Assignment> assignments;

    @ManyToMany(mappedBy = "members")
    private List<Team> teams;
}
