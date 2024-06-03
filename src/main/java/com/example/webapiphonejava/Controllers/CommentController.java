package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.CategoryDTO;
import com.example.webapiphonejava.DTO.CommentDTO;
import com.example.webapiphonejava.Services.CategoryService;
import com.example.webapiphonejava.Services.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<CommentDTO>>> getAllComment() {
        BaseResponse<List<CommentDTO>> baseResponse = commentService.getAllComment();
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<CommentDTO>> addComment(
            @Valid @RequestBody CommentDTO commentDTO,
            @RequestParam("categoryId") Integer categoryId
            ) {
        BaseResponse<CommentDTO> baseResponse = commentService.addComment(commentDTO, categoryId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<CommentDTO>> updateCommentById(
            @Valid @RequestBody CommentDTO commentDTO,
            @RequestParam("commentId") Integer commentId,
            @RequestParam("categoryId") Integer categoryId
    ) {
        BaseResponse<CommentDTO> baseResponse = commentService.updateCommentById(commentDTO, commentId, categoryId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<CommentDTO>> deleteCommentById(@RequestParam("commentId") Integer commentId) {
        BaseResponse<CommentDTO> baseResponse = commentService.deleteCommentById(commentId);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
    }
}
