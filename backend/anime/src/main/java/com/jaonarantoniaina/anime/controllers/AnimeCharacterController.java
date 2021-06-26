package com.jaonarantoniaina.anime.controllers;

import com.jaonarantoniaina.anime.entities.AnimeCharacter;
import com.jaonarantoniaina.anime.entities.Users;
import com.jaonarantoniaina.anime.repositories.IAnimeCharacter;
import com.jaonarantoniaina.anime.repositories.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/animes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AnimeCharacterController {

    @Autowired
    private IAnimeCharacter animeCharacterRepository;
    @Autowired
    private IUser userRepository;

    @GetMapping("/")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(animeCharacterRepository.findAll());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity findAllUserCharacters(@PathVariable(name = "idUser") Long idUser) {
        if (idUser == null) {
            return ResponseEntity.badRequest().body("Cannot find anime with null user");
        }
            Optional<Users> users = userRepository.findById(idUser);
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok(animeCharacterRepository.findByUsersOrShared(users.get(), true));
    }

    @GetMapping("/idAnime")
    public ResponseEntity findAnimeById(@PathVariable(name = "idAnime") Long idAnime) {
        if (idAnime == null) {
            return ResponseEntity.badRequest().body("Cannot find anime character with null ID");
        }
        AnimeCharacter animeCharacter = animeCharacterRepository.getById(idAnime);
        if (animeCharacter == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(animeCharacter);
    }

    @PostMapping("/")
    public ResponseEntity createAnimeCharacter(@RequestBody AnimeCharacter animeCharacter) {
        if (animeCharacter == null) {
            return ResponseEntity.badRequest().body("Cannot create anime character with empty fields");
        }
        return ResponseEntity.ok(animeCharacterRepository.save(animeCharacter));
    }

    @DeleteMapping("/{idAnime}")
    public ResponseEntity deleteAnimeCharacter(@PathVariable(name = "idAnime") Long idAnime) {
        if (idAnime == null) {
            return ResponseEntity.badRequest().body("Cannot remove character with null ID");
        }
        AnimeCharacter animeCharacter = animeCharacterRepository.getById(idAnime);
        if (animeCharacter == null) {
            return ResponseEntity.notFound().build();
        }
        animeCharacterRepository.delete(animeCharacter);
        return ResponseEntity.ok("Character removed with success");
    }

    @GetMapping("/share/{idAnime}/{isShared}")
    public ResponseEntity shareCharacter(@PathVariable(name = "idAnime") Long idAnime, @PathVariable(name = "isShared") boolean isShared) {
        if (idAnime == null) {
            return ResponseEntity.badRequest().body("Cannot remove character with null ID");
        }
        AnimeCharacter animeCharacter = animeCharacterRepository.getById(idAnime);
        if (animeCharacter == null) {
            return ResponseEntity.notFound().build();
        }
        animeCharacter.setShared(isShared);
        return ResponseEntity.ok(animeCharacterRepository.save(animeCharacter));
    }
}
