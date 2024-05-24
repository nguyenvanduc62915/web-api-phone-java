package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.CommentDTO;
import com.example.webapiphonejava.Models.Comment;
import com.example.webapiphonejava.Repositories.CommentRepository;
import com.example.webapiphonejava.Services.Imp.CommentImp;
import com.example.webapiphonejava.Utils.Constant;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService implements CommentImp {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public BaseResponse<List<CommentDTO>> getAllComment() {
        BaseResponse<List<CommentDTO>> baseResponse = new BaseResponse<>();
        List<CommentDTO> commentDTOList = new ArrayList<>();
        try {
            List<Comment> commentList = commentRepository.findAll();
            if (commentList.isEmpty() || commentList == null){
                baseResponse.setMessage(Constant.EMPTY_ALL_COMMENT);
                baseResponse.setCode(Constant.SUCCESS_CODE);
                return baseResponse;
            }
            for (Comment comment : commentList){
                CommentDTO commentDTO = new CommentDTO();
                commentDTO.setCommentId(comment.getId());
                commentDTO.setFullName(comment.getFullName());
                commentDTO.setPhone(comment.getPhone());
                commentDTO.setContent(comment.getContent());
                commentDTO.setDateAndTime(comment.getDateAndTime());
                commentDTO.setCreateAt(comment.getCreateAt());
                commentDTO.setUpdateAt(comment.getUpdateAt());
                commentDTOList.add(commentDTO);
            }
            baseResponse.setData(commentDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_COMMENT);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CommentDTO> addComment(CommentDTO commentDTO) {
        BaseResponse<CommentDTO> baseResponse = new BaseResponse<>();
        try {
            Comment comment = new Comment();
            comment.setFullName(commentDTO.getFullName());
            comment.setContent(commentDTO.getContent());
            comment.setPhone(commentDTO.getPhone());
            comment.setDateAndTime(commentDTO.getDateAndTime());
            comment.setUpdateAt(commentDTO.getUpdateAt());
            commentRepository.save(comment);
            baseResponse.setData(commentDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_COMMENT);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CommentDTO> updateCommentById(CommentDTO commentDTO, Integer commentId) {
        BaseResponse<CommentDTO> baseResponse = new BaseResponse<>();
        try {
            Comment comment = commentRepository.findCommentById(commentId);
            if (comment == null){
                baseResponse.setMessage(Constant.EMPTY_COMMENT_ID + commentId);
                baseResponse.setCode(Constant.SUCCESS_CODE);
                return baseResponse;
            }
            comment.setFullName(commentDTO.getFullName());
            comment.setContent(commentDTO.getContent());
            comment.setPhone(commentDTO.getPhone());
            comment.setDateAndTime(commentDTO.getDateAndTime());
            comment.setUpdateAt(commentDTO.getUpdateAt());
            baseResponse.setData(commentDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_COMMENT);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CommentDTO> deleteCommentById(Integer commentId) {
        BaseResponse<CommentDTO> baseResponse = new BaseResponse<>();
        try {
            Comment comment = commentRepository.findCommentById(commentId);
            if (comment == null){
                baseResponse.setMessage(Constant.EMPTY_COMMENT_ID + commentId);
                baseResponse.setCode(Constant.SUCCESS_CODE);
                return baseResponse;
            }
            commentRepository.delete(comment);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_COMMENT);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
