package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.CommentDTO;

import java.util.List;

public interface CommentImp {
    BaseResponse<List<CommentDTO>> getAllComment();
    BaseResponse<CommentDTO> addComment(CommentDTO commentDTO, Integer productId);
    BaseResponse<CommentDTO> updateCommentById(CommentDTO commentDTO, Integer commentId, Integer productId);
    BaseResponse<CommentDTO> deleteCommentById(Integer commentId);
}
