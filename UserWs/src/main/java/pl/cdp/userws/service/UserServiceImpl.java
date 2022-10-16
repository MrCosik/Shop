package pl.cdp.userws.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.cdp.userws.dto.UserDTO;
import pl.cdp.userws.entity.UserEntity;
import pl.cdp.userws.repository.UserRepository;


import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDTO createUser(UserDTO userDetails) {
        userDetails.setId(UUID.randomUUID().toString());
        userDetails.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);


        repository.save(userEntity);

        return modelMapper.map(userEntity,UserDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity =  repository.findByUsername(username);
        if(userEntity == null) throw new UsernameNotFoundException(username);

        return new User(userEntity.getUsername(), userEntity.getPassword(), true,true,true,true,new ArrayList<>());
    }

    @Override
    public UserDTO getUserDetailsByEmail(String email) {
        UserEntity userEntity = repository.findByUsername(email);
        if(userEntity == null) throw new UsernameNotFoundException(email);

        return new ModelMapper().map(userEntity, UserDTO.class);
    }

    @Override
    public UserDTO getUserByUserId(Long id) {
        UserEntity userEntity = repository.findById(id).get();
        ModelMapper modelMapper = new ModelMapper();


        if(userEntity == null) throw new UsernameNotFoundException("User not found");


        return modelMapper.map(userEntity, UserDTO.class);
    }
}
