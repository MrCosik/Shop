package pl.cdp.userws.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.cdp.userws.entity.Role;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO {

    private String id;
    private String username;
    private String password;
    private Set<Role> role;
}
