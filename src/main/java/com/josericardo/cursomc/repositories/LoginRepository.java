package com.josericardo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.josericardo.cursomc.domain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

}
