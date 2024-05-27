package com.example.webapiphonejava.Services;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ShipperDTO;
import com.example.webapiphonejava.Models.Shipper;
import com.example.webapiphonejava.Repositories.ShipperRepository;
import com.example.webapiphonejava.Services.Imp.ShipperImp;
import com.example.webapiphonejava.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipperService implements ShipperImp {
    @Autowired
    private ShipperRepository shipperRepository;

    @Override
    public BaseResponse<List<ShipperDTO>> getAllShipper() {
        BaseResponse<List<ShipperDTO>> baseResponse = new BaseResponse<>();
        List<ShipperDTO> shipperDTOList = new ArrayList<>();
        try {
            List<Shipper> shipperList = shipperRepository.findAll();
            if (shipperList.isEmpty() || shipperList == null){
                baseResponse.setMessage(Constant.EMPTY_ALL_SHIPPER);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            for (Shipper shipper : shipperList){
                ShipperDTO shipperDTO = new ShipperDTO();
                shipperDTO.setShipperId(shipper.getId());
                shipperDTO.setShipperName(shipper.getShipperName());
                shipperDTO.setPhoneShipperOne(shipper.getPhoneShipperOne());
                shipperDTO.setPhoneShipperTwo(shipper.getPhoneShipperTwo());
                shipperDTO.setCreateAt(shipper.getCreateAt());
                shipperDTO.setUpdateAt(shipper.getUpdateAt());
                shipperDTOList.add(shipperDTO);
            }
            baseResponse.setData(shipperDTOList);
            baseResponse.setMessage(Constant.SUCCESS_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_SHIPPER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
    public BaseResponse<ShipperDTO> addShipper(ShipperDTO shipperDTO) {
        BaseResponse<ShipperDTO> baseResponse = new BaseResponse<>();
        try {
            Shipper shipper = new Shipper();
            shipper.setId(shipperDTO.getShipperId());
            shipper.setShipperName(shipperDTO.getShipperName());
            shipper.setPhoneShipperOne(shipperDTO.getPhoneShipperOne());
            shipper.setPhoneShipperTwo(shipperDTO.getPhoneShipperTwo());
            shipper.setCreateAt(shipperDTO.getCreateAt());
            shipperRepository.save(shipper);
            baseResponse.setData(shipperDTO);
            baseResponse.setMessage(Constant.SUCCESS_ADD_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_SHIPPER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ShipperDTO> updateShipperById(ShipperDTO shipperDTO, Integer shipperId) {
        BaseResponse<ShipperDTO> baseResponse = new BaseResponse<>();
        try {
            Shipper shipper = shipperRepository.findShipperById(shipperId);
            if (shipper == null){
                baseResponse.setMessage(Constant.EMPTY_SHIPPER_ID + shipperId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            shipper.setShipperName(shipperDTO.getShipperName());
            shipper.setPhoneShipperOne(shipperDTO.getPhoneShipperOne());
            shipper.setPhoneShipperTwo(shipperDTO.getPhoneShipperTwo());
            shipper.setUpdateAt(shipperDTO.getUpdateAt());
            shipperRepository.save(shipper);
            baseResponse.setData(shipperDTO);
            baseResponse.setMessage(Constant.SUCCESS_UPDATE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_SHIPPER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse<ShipperDTO> deleteShipperById(Integer shipperId) {
        BaseResponse<ShipperDTO> baseResponse = new BaseResponse<>();
        try {
            Shipper shipper = shipperRepository.findShipperById(shipperId);
            if (shipper == null){
                baseResponse.setMessage(Constant.EMPTY_SHIPPER_ID + shipperId);
                baseResponse.setCode(Constant.NOT_FOUND_CODE);
                return baseResponse;
            }
            shipperRepository.delete(shipper);
            baseResponse.setMessage(Constant.SUCCESS_DELETE_MESSAGE);
            baseResponse.setCode(Constant.SUCCESS_CODE);
        } catch (Exception ex){
            baseResponse.setMessage(Constant.ERROR_TO_GET_SHIPPER);
            baseResponse.setCode(Constant.INTERNAL_SERVER_ERROR_CODE);
        }
        return baseResponse;
    }
}
