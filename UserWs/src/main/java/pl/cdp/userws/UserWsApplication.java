package pl.cdp.userws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.cdp.userws.entity.Role;
import pl.cdp.userws.entity.UserEntity;
import pl.cdp.userws.repository.UserRepository;
import pl.cdp.userws.util.Roles;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class UserWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserWsApplication.class, args);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner init (UserRepository userRepository){
        return args -> {
            UserEntity user = new UserEntity();
            UserEntity admin = new UserEntity();

            user.setUsername("user");
            user.setPassword(bCryptPasswordEncoder().encode("password"));
            user.getRoles().add(Role.builder().name(Roles.USER.name()).build());

            admin.setUsername("admin");
            admin.setPassword(bCryptPasswordEncoder().encode("password"));
            admin.getRoles().add(Role.builder().name(Roles.USER.name()).build());
            admin.getRoles().add(Role.builder().name(Roles.ADMIN.name()).build());


            List<String> names = Arrays.asList("udara", "sampath");
            names.forEach(name -> userRepository.saveAll(Arrays.asList(admin, user)));
        };
    }

}
