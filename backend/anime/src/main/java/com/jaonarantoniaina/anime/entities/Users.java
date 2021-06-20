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
}
