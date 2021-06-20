package com.jaonarantoniaina.anime.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users implements Serializable {
    @Id
    @GeneratedValue
    private Long idUsers;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    @Lob
    private byte[] photo;
    @OneToMany(mappedBy = "users")
    private List<AnimeCharacter> characters;

    public Users() {
    }

    public Users(Long idUsers, String firstName, String lastName, String mail, String password, byte[] photo, List<AnimeCharacter> characters) {
        this.idUsers = idUsers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.photo = photo;
        this.characters = characters;
    }

    public Long getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Long idUsers) {
        this.idUsers = idUsers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public List<AnimeCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(List<AnimeCharacter> characters) {
        this.characters = characters;
    }
}
