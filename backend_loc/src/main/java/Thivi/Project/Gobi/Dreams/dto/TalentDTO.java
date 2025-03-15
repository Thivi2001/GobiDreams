package Thivi.Project.Gobi.Dreams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalentDTO {
    private Long id;
    private String name;
    private String talentType;
    private String portfolioUrl;
    private String status;
}
