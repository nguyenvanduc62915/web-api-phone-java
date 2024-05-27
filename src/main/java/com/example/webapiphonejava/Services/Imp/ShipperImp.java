package com.example.webapiphonejava.Services.Imp;

import com.example.webapiphonejava.DTO.BaseResponse;
import com.example.webapiphonejava.DTO.ShipperDTO;

import java.util.List;

public interface ShipperImp {
    BaseResponse<List<ShipperDTO>> getAllShipper();
    BaseResponse<ShipperDTO> addShipper(ShipperDTO shipperDTO);
    BaseResponse<ShipperDTO> updateShipperById(ShipperDTO shipperDTO, Integer shipperId);
    BaseResponse<ShipperDTO> deleteShipperById(Integer shipperId);
}
