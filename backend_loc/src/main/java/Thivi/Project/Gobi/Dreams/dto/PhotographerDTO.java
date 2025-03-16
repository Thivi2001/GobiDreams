package Thivi.Project.Gobi.Dreams.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotographerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String portfolioLink;
    private int experienceYears;
}
