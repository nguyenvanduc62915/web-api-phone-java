package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.UserDTO;
import com.example.webapiphonejava.Models.User;
import com.example.webapiphonejava.Repositories.UserRepository;
import com.example.webapiphonejava.Services.Imp.UserImp;
import com.example.webapiphonejava.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserImp {
    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseResponse<List<UserDTO>> getAllUser() {
        BaseResponse<List<UserDTO>> baseResponse = new BaseResponse<>();
        List<UserDTO> userDTOList = new ArrayList<>();
        try {
            List<User> userList = userRepository.findAll();
            if (userList.isEmpty() || userList == null){
                baseResponse.setMessage(Constant.EMPTY_ALL_USER);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            for (User user : userList){
                UserDTO userDTO = new UserDTO();
                userDTO.setUserId(user.getId());
                userDTO.setUserName(user.getUsername());
                userDTO.setName(user.getName());
                userDTO.setPassword(user.getPassword());
                userDTO.setCreateAt(user.getCreateAt());
                userDTO.setUpdateAt(user.getUpdateAt());
                userDTOList.add(userDTO);
            }
            baseResponse.setData(userDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_USER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<UserDTO> addUser(UserDTO userDTO) {
        BaseResponse<UserDTO> baseResponse = new BaseResponse<>();
        try {
            User user = new User();
            user.setUserName(userDTO.getUserName());
            user.setPassword(userDTO.getPassword());
            user.setName(userDTO.getName());
            user.setCreateAt(userDTO.getCreateAt());
            userRepository.save(user);
            baseResponse.setData(userDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_USER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<UserDTO> updateUserById(UserDTO userDTO, Integer userId) {
        BaseResponse<UserDTO> baseResponse = new BaseResponse<>();
        try {
            User user = userRepository.findUserById(userId);
            if (user == null){
                baseResponse.setMessage(Constant.EMPTY_USER_ID + userId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            user.setUserName(userDTO.getUserName());
            user.setPassword(userDTO.getPassword());
            user.setName(userDTO.getName());
            user.setUpdateAt(userDTO.getUpdateAt());
            userRepository.save(user);
            baseResponse.setData(userDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_USER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<UserDTO> deleteUserById(Integer userId) {
        BaseResponse<UserDTO> baseResponse = new BaseResponse<>();
        try {
            User user = userRepository.findUserById(userId);
            if (user == null){
                baseResponse.setMessage(Constant.EMPTY_USER_ID + userId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            userRepository.delete(user);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_USER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
