package br.com.fatesg.eventos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatesg.eventos.entities.Login;

public interface LoginPersistence extends JpaRepository<Login, Long> {}
