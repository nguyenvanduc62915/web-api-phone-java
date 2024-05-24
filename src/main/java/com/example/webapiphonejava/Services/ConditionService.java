package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ConditionDTO;
import com.example.webapiphonejava.Models.Condition;
import com.example.webapiphonejava.Repositories.ConditionRepository;
import com.example.webapiphonejava.Services.Imp.ConditionImp;
import com.example.webapiphonejava.Utils.Constant;
import org.apache.tomcat.util.bcel.Const;
import org.aspectj.apache.bcel.classfile.ConstantString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConditionService implements ConditionImp {
    @Autowired
    private ConditionRepository conditionRepository;

    @Override
    public BaseResponse<List<ConditionDTO>> getAllCondition() {
        BaseResponse<List<ConditionDTO>> baseResponse = new BaseResponse<>();
        List<ConditionDTO> conditionDTOList = new ArrayList<>();
        try {
            List<Condition> conditionList = conditionRepository.findAll();
            if (conditionList.isEmpty() || conditionList == null){
                baseResponse.setMessage(Constant.EMPTY_ALL_CONDITION);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            for (Condition condition : conditionList){
                ConditionDTO conditionDTO = new ConditionDTO();
                conditionDTO.setConditionId(condition.getId());
                conditionDTO.setOrderStatus(condition.getOrderStatus());
                conditionDTO.setUpdateAt(condition.getUpdateAt());
                conditionDTO.setCreateAt(condition.getCreateAt());
                conditionDTOList.add(conditionDTO);
            }
            baseResponse.setData(conditionDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_CONDITION);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ConditionDTO> addCondition(ConditionDTO conditionDTO) {
        BaseResponse<ConditionDTO> baseResponse = new BaseResponse<>();
        try {
            Condition condition = new Condition();
            condition.setOrderStatus(conditionDTO.getOrderStatus());
            condition.setCreateAt(conditionDTO.getCreateAt());
            conditionRepository.save(condition);
            baseResponse.setData(conditionDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_CONDITION);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ConditionDTO> updateConditionById(ConditionDTO conditionDTO, Integer conditionId) {
        BaseResponse<ConditionDTO> baseResponse = new BaseResponse<>();
        try {
            Condition condition = conditionRepository.findConditionId(conditionId);
            if (condition == null){
                baseResponse.setMessage(Constant.EMPTY_CONDITION_ID + conditionId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            condition.setOrderStatus(conditionDTO.getOrderStatus());
            condition.setUpdateAt(conditionDTO.getUpdateAt());
            conditionRepository.save(condition);
            baseResponse.setData(conditionDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_CONDITION);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ConditionDTO> deleteConditionById(Integer conditionId) {
        BaseResponse<ConditionDTO> baseResponse = new BaseResponse<>();
        try {
            Condition condition = conditionRepository.findConditionId(conditionId);
            if (condition == null){
                baseResponse.setMessage(Constant.EMPTY_CONDITION_ID + conditionId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            conditionRepository.delete(condition);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_CONDITION);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
