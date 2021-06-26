package com.jaonarantoniaina.anime.repositories;

import com.jaonarantoniaina.anime.entities.AnimeCharacter;
import com.jaonarantoniaina.anime.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAnimeCharacter extends JpaRepository<AnimeCharacter, Long> {
    List<AnimeCharacter> findByUsersOrShared(Users users, boolean shared);
}
