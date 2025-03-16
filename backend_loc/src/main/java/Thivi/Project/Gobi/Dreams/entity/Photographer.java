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
public class Photographer extends User {

    @Column(name = "portfolio_link")
    private String portfolioLink;

    @Column(name = "experience_years")
    private int experienceYears;
}
