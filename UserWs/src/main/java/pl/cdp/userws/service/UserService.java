package pl.cdp.userws.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.cdp.userws.dto.UserDTO;

public interface UserService extends UserDetailsService {
    UserDTO createUser(UserDTO userDetails);
    UserDTO getUserDetailsByEmail(String email);
    UserDTO getUserByUserId(Long id);
}
