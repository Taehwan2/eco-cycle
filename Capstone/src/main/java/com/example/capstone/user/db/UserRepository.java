package com.example.capstone.user.db;

import com.example.capstone.user.db.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {


    Optional<UserEntity> findByPhonenum(String phonenum);


    Optional<UserEntity> findByEmail(String email);
}
