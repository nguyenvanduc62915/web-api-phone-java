package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.CategoryDTO;
import com.example.webapiphonejava.Models.Category;
import com.example.webapiphonejava.Repositories.CategorRepository;
import com.example.webapiphonejava.Services.Imp.CategoryImp;
import com.example.webapiphonejava.Utils.Constant;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryImp {
    @Autowired
    private CategorRepository categorRepository;

    @Override
    public BaseResponse<List<CategoryDTO>> getAllCategory() {
        BaseResponse<List<CategoryDTO>> baseResponse = new BaseResponse<>();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        try {
            List<Category> categoryList = categorRepository.findAll();
            if (categoryList.isEmpty() || categoryList == null){
                baseResponse.setMessage(Constant.EMPTY_ALL_CATEGORY);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            for (Category category : categoryList){
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setCategoryId(category.getId());
                categoryDTO.setCategoryName(category.getCategoryName());
                categoryDTO.setCreateAt(category.getCreateAt());
                categoryDTO.setUpdateAt(category.getUpdateAt());
                categoryDTOList.add(categoryDTO);
            }
            baseResponse.setData(categoryDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_CATEGORY);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CategoryDTO> addCategory(CategoryDTO categoryDTO) {
        BaseResponse<CategoryDTO> baseResponse = new BaseResponse<>();
        try {
            Category category = new Category();
            category.setCategoryName(categoryDTO.getCategoryName());
            category.setCreateAt(categoryDTO.getCreateAt());
            categorRepository.save(category);
            baseResponse.setData(categoryDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_CATEGORY);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CategoryDTO> updateCategoryById(CategoryDTO categoryDTO, Integer categoryId) {
        BaseResponse<CategoryDTO> baseResponse = new BaseResponse<>();
        try {
            Category category = categorRepository.findCategoryById(categoryId);
            if (category == null) {
                baseResponse.setMessage(Constant.EMPTY_CATEGORY_ID + categoryId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            category.setCategoryName(categoryDTO.getCategoryName());
            category.setUpdateAt(categoryDTO.getUpdateAt());
            categorRepository.save(category);
            baseResponse.setData(categoryDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex) {
            baseResponse.setMessage(Constant.ERROR_TO_GET_CATEGORY);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<CategoryDTO> deleteCategoryById(Integer categoryId) {
        BaseResponse<CategoryDTO> baseResponse = new BaseResponse<>();
        try {
            Category category = categorRepository.findCategoryById(categoryId);
            if (category == null) {
                baseResponse.setMessage(Constant.EMPTY_CATEGORY_ID + categoryId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            categorRepository.delete(category);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex) {
            baseResponse.setMessage(Constant.ERROR_TO_GET_CATEGORY);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
