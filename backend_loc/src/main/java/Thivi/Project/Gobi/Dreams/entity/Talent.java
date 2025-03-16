package Thivi.Project.Gobi.Dreams.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "portfolio_link")
    private String portfolioLink;

    @Column(nullable = false)
    private String skills;

    @Column(nullable = false)
    private String bio;

    @Column(name = "status")
    private String status; // e.g., "Pending", "Verified", "Rejected"
}
