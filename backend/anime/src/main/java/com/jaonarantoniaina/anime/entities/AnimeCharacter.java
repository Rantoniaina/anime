package com.jaonarantoniaina.anime.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUsers")
    private Users users;

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
