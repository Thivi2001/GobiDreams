package Thivi.Project.Gobi.Dreams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDTO {
    private Long id;
    private Long photographerId;
    private Long customerId;
    private String photoUrl;
    private String status;
}
