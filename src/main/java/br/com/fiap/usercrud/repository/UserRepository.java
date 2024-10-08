package br.com.fiap.usercrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.usercrud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}


