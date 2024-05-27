package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.UserDTO;

import java.util.List;

public interface UserImp {
    BaseResponse<List<UserDTO>> getAllUser();
    BaseResponse<UserDTO> addUser(UserDTO userDTO);
    BaseResponse<UserDTO> updateUserById(UserDTO userDTO, Integer userId);
    BaseResponse<UserDTO> deleteUserById(Integer userId);
}
