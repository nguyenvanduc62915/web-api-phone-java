package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ConditionDTO;

import java.util.List;

public interface ConditionImp {
    BaseResponse<List<ConditionDTO>> getAllCondition();
    BaseResponse<ConditionDTO> addCondition(ConditionDTO conditionDTO);
    BaseResponse<ConditionDTO> updateConditionById(ConditionDTO conditionDTO, Integer conditionId);
    BaseResponse<ConditionDTO> deleteConditionById(Integer conditionId);
}
