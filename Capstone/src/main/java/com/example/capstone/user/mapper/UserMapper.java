package com.example.capstone.user.mapper;


import com.example.capstone.user.db.UserEntity;
import com.example.capstone.user.model.UserPostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity userPostDtoToUserEntity(UserPostDto userPostDto);
}
