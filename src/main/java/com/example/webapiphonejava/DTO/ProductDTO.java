package com.example.webapiphonejava.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private int productId;
    @Size(max = 100, message = "Tên sản phẩm cho phép tối đa 100 kỹ tự!")
    private int productName;
    @Size(max = 50, message = "Ảnh sản phẩm cho phép tối đa 100 kỹ tự!")
    private int productImage;
    private int price;
    private int amount;
    @Size(max = 255, message = "Kích thước sản phẩm tối đâ 255 ký tự!")
    private String dimension;
    @Size(max = 255, message = "Trọng lượng sản phẩm tối đâ 255 ký tự!")
    private String weight;
    @Size(max = 255, message = "Màu sắc sản phẩm tối đâ 255 ký tự!")
    private String color;
    @Size(max = 255, message = "Âm thanh sản phẩm tối đâ 255 ký tự!")
    private String sound;
    @Size(max = 255, message = "Bộ nhớ sản phẩm tối đâ 255 ký tự!")
    private String memory;
    @Size(max = 255, message = "Hệ điêù hành sản phẩm tối đâ 255 ký tự!")
    private String operatingSystem;
    @Size(max = 255, message = "Thẻ nhớ sản phẩm tối đâ 255 ký tự!")
    private String memoryCard;
    @Size(max = 255, message = "Camera sản phẩm tối đâ 255 ký tự!")
    private String camera;
    @Size(max = 255, message = "Pin sản phẩm tối đâ 255 ký tự!")
    private String battery;
    @Size(max = 255, message = "Bảo hành sản phẩm tối đâ 255 ký tự!")
    private String warranty;
    @Size(max = 255, message = "Kết nối các thiết bị của sản phẩm tối đâ 255 ký tự!")
    private String connection;
    private int sale;
    private LocalDate startSale;
    private LocalDate endSale;
    private LocalDate createAt;
    private LocalDate updateAt;
}
