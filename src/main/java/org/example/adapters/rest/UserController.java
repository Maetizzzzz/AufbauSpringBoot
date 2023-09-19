package org.example.adapters.rest;

import lombok.RequiredArgsConstructor;
import org.example.adapters.database.UserDB;
import org.example.adapters.database.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<UserDB> getUsers() {
        return (List<UserDB>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody UserDB userDB) {
        userRepository.save(userDB);
    }
}
