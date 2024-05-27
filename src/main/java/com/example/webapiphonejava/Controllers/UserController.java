package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.UserDTO;
import com.example.webapiphonejava.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<UserDTO>>> getAllUser() {
        BaseResponse<List<UserDTO>> baseResponse = userService.getAllUser();
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<UserDTO>> addUser(@Valid @RequestBody UserDTO userDTO) {
        BaseResponse<UserDTO> baseResponse = userService.addUser(userDTO);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<UserDTO>> updateUserById(
            @Valid @RequestBody UserDTO userDTO,
            @RequestParam("userId") Integer userId
    ) {
        BaseResponse<UserDTO> baseResponse = userService.updateUserById(userDTO, userId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/delete")
    public ResponseEntity<BaseResponse<UserDTO>> deleteUserById(@RequestParam("userId") Integer userId) {
        BaseResponse<UserDTO> baseResponse = userService.deleteUserById(userId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }
}