package br.com.showmusic.app.service;

import br.com.showmusic.app.enums.EnumUserType;
import br.com.showmusic.app.model.UserLogin;
import br.com.showmusic.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public UserLogin addUser(UserLogin userLogin)throws Exception{
       Optional <List<UserLogin>> users = userRepository.findAllByUsername(userLogin.getUsername());

        if(users.isPresent() && !users.get().isEmpty()){
            throw new Exception("Esse usuário já exíste!");
        }
        userLogin.setType(EnumUserType.USER);
        return userRepository.save(userLogin);
    }
}
