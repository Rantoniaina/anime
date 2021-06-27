package com.jaonarantoniaina.anime.controllers;

import com.jaonarantoniaina.anime.entities.AnimeCharacter;
import com.jaonarantoniaina.anime.entities.Users;
import com.jaonarantoniaina.anime.repositories.IAnimeCharacter;
import com.jaonarantoniaina.anime.repositories.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/v1/photo")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PhotoController {

    @Autowired
    private IAnimeCharacter animeCharacterRepository;
    @Autowired
    private IUser userRepository;

    @GetMapping("/character/{idCharacter}")
    public ResponseEntity photoCharacter(@PathVariable Long idCharacter) {
        if (idCharacter == null) {
            return ResponseEntity.badRequest().body("Cannot get character photo with null ID");
        }
        AnimeCharacter character = animeCharacterRepository.getById(idCharacter);
        if (character == null || character.getPhoto() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentType(MediaType.IMAGE_GIF).contentType(MediaType.IMAGE_PNG).body(new InputStreamResource((new ByteArrayInputStream(character.getPhoto()))));
    }

    @GetMapping("/users/{idUser}")
    public ResponseEntity photoUser(@PathVariable Long idUser) {
        if (idUser == null) {
            return ResponseEntity.badRequest().body("Cannot get photo photo with null ID");
        }
        Users users = userRepository.getById(idUser);
        if (users == null || users.getPhoto() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentType(MediaType.IMAGE_GIF).contentType(MediaType.IMAGE_PNG).body(new InputStreamResource((new ByteArrayInputStream(users.getPhoto()))));
    }
}
