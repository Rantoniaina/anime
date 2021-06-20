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

    public AnimeCharacter() {
    }

    public AnimeCharacter(Long idAnime, String animeName, String category, String strength, byte[] photo, boolean shared, Users users) {
        this.idAnime = idAnime;
        this.animeName = animeName;
        this.category = category;
        this.strength = strength;
        this.photo = photo;
        this.shared = shared;
        this.users = users;
    }

    public Long getIdAnime() {
        return idAnime;
    }

    public void setIdAnime(Long idAnime) {
        this.idAnime = idAnime;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
