package com.jaonarantoniaina.anime.controllers;

import com.jaonarantoniaina.anime.entities.Users;
import com.jaonarantoniaina.anime.repositories.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UsersController {

    @Autowired
    private IUser userRepository;

    @GetMapping("/")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity findUserById(@PathVariable(name = "idUser") Long idUser) {
        if(idUser == null) {
            return ResponseEntity.badRequest().body("Cannot retrieve user with null ID");
        }
        Users users = userRepository.getById(idUser);
        if (users == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody Users users) {
        if (users == null) {
            return ResponseEntity.badRequest().body("Cannot create user with empty fields");
        }
        Users createdUsers = userRepository.save(users);
        return ResponseEntity.ok(createdUsers);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam(name = "mail") String mail, @RequestParam(name = "password") String password) {
        if (StringUtils.hasText(mail) || StringUtils.hasText(password)) {
            return ResponseEntity.badRequest().body("Cannot login with empty user mail or password");
        }
        Users authenticatedUser = userRepository.findByMailAndPassword(mail, password);
        if (authenticatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(authenticatedUser);
    }
}
