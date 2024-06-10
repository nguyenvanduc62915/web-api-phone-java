package com.example.webapiphonejava.Controllers;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.CommentDTO;
import com.example.webapiphonejava.DTO.ConditionDTO;
import com.example.webapiphonejava.Models.Condition;
import com.example.webapiphonejava.Services.ConditionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/condition")
public class ConditionController {
    @Autowired
    private ConditionService conditionService;

    @GetMapping("/get_all")
    public ResponseEntity<BaseResponse<List<ConditionDTO>>> getAllCondition(){
        BaseResponse<List<ConditionDTO>> baseResponse = conditionService.getAllCondition();
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<ConditionDTO>> addCondition(@Valid @RequestBody ConditionDTO conditionDTO) {
        BaseResponse<ConditionDTO> baseResponse = conditionService.addCondition(conditionDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<ConditionDTO>> updateConditionById(
            @Valid @RequestBody ConditionDTO conditionDTO,
            @RequestParam("conditionId") Integer conditionId
    ) {
        BaseResponse<ConditionDTO> baseResponse = conditionService.updateConditionById(conditionDTO, conditionId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse<ConditionDTO>> deleteConditionById(@RequestParam("conditionId") Integer conditionId) {
        BaseResponse<ConditionDTO> baseResponse = conditionService.deleteConditionById(conditionId);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
