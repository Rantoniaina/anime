package com.jaonarantoniaina.anime.repositories;

import com.jaonarantoniaina.anime.entities.AnimeCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAnimeCharacter extends JpaRepository<AnimeCharacter, Long> {
}
