package Thivi.Project.Gobi.Dreams.dto;

import Thivi.Project.Gobi.Dreams.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
