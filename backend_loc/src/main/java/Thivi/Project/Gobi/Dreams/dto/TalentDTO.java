package Thivi.Project.Gobi.Dreams.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TalentDTO {

    private Long id;
    private Long userId;
    private String portfolioLink;
    private String skills;
    private String bio;
    private String status;  // e.g., "Pending", "Verified", "Rejected"
}
