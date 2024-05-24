package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.CategoryDTO;

import java.util.List;

public interface CategoryImp {
    BaseResponse<List<CategoryDTO>> getAllCategory();
    BaseResponse<CategoryDTO> addCategory(CategoryDTO categoryDTO);
    BaseResponse<CategoryDTO> updateCategoryById(CategoryDTO categoryDTO, Integer categoryId);
    BaseResponse<CategoryDTO> deleteCategoryById(Integer categoryId);
}
