package com.jaonarantoniaina.anime.repositories;

import com.jaonarantoniaina.anime.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<Users, Long> {
    Users findByMailAndPassword(String mail, String password);
    Users findByIdUsers(Long idUsers);
}
