package Thivi.Project.Gobi.Dreams.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "talents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Talent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String skills;

    @Column(nullable = false)
    private String bio;
}
