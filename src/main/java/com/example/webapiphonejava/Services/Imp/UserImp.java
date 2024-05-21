package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.UserDTO;
import com.example.webapiphonejava.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserImp extends JpaRepository<Integer, User> {
    BaseResponse<List<UserDTO>> getAllUser();
    BaseResponse<UserDTO> addUser(UserDTO userDTO);
    BaseResponse<UserDTO> updateAll(int userId, UserDTO userDTO);
    BaseResponse<User> deleteById(int userId);
}
