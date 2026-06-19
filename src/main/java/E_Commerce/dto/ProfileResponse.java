package E_Commerce.dto;

import E_Commerce.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileResponse {

    private Long id;
    private String name;
    private String email;
    private Role role;

}
