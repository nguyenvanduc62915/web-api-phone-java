package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.CategoryDTO;
import com.example.webapiphonejava.Services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<CategoryDTO>>> getAllCategory() {
        BaseResponse<List<CategoryDTO>> baseResponse = categoryService.getAllCategory();
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<CategoryDTO>> addCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        BaseResponse<CategoryDTO> baseResponse = categoryService.addCategory(categoryDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<CategoryDTO>> updateCategoryById(
            @Valid @RequestBody CategoryDTO categoryDTO,
            @RequestParam("categoryId") Integer categoryId
    ) {
        BaseResponse<CategoryDTO> baseResponse = categoryService.updateCategoryById(categoryDTO, categoryId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<CategoryDTO>> deleteCategoryById(@RequestParam("categoryId") Integer categoryId) {
        BaseResponse<CategoryDTO> baseResponse = categoryService.deleteCategoryById(categoryId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
