package com.jaonarantoniaina.anime.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AnimeCharacter implements Serializable {
    @Id
    @GeneratedValue
    private Long idAnime;
    private String animeName;
    private String category;
    private String strength;
    @Lob
    private byte[] photo;
    private boolean shared;
    @ManyToOne
    @JoinColumn(name = "idUsers")
    private Users users;
}
