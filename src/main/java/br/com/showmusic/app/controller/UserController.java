package br.com.showmusic.app.controller;


import br.com.showmusic.app.model.UserLogin;
import br.com.showmusic.app.model.UserResponse;
import br.com.showmusic.app.repository.UserRepository;
import br.com.showmusic.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @GetMapping("/all")
    public ResponseEntity<List<UserLogin>> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping(path = "/create-user", consumes = "application/json", produces = "application/json")
    public ResponseEntity create(@RequestBody UserLogin userLogin)  {

        UserResponse userResponse = new UserResponse();
            try {
                userService.addUser(userLogin);
            }catch (Exception e){
                userResponse.setMessage(e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userResponse);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(userLogin);
    }
}