package com.example.webapiphonejava.Utils;

import com.example.webapiphonejava.DTO.BillDTO;
import com.example.webapiphonejava.DTO.BillDetailsDTO;
import com.example.webapiphonejava.DTO.CategoryDTO;
import com.example.webapiphonejava.DTO.UserDTO;
import com.example.webapiphonejava.Models.Bill;
import com.example.webapiphonejava.Models.BillDetails;
import com.example.webapiphonejava.Models.Category;
import com.example.webapiphonejava.Models.User;
import org.springframework.stereotype.Component;

@Component
public class ConvertRelationship {
    public Bill convertToBill(BillDTO billDTO){
        Bill bill = new Bill();
        bill.setId(billDTO.getBillId());
        bill.setNote(billDTO.getNote());
        bill.setReceivingAddress(billDTO.getReceivingAddress());
        bill.setTotalAmount(billDTO.getTotalAmount());
        bill.setOrderDate(billDTO.getOrderDate());
        bill.setCreateAt(billDTO.getCreateAt());
        bill.setUpdateAt(billDTO.getUpdateAt());
        return bill;
    }

    public BillDTO convertToBillDTO(Bill bill){
        BillDTO billDTO = new BillDTO();
        billDTO.setBillId(bill.getId());
        billDTO.setNote(bill.getNote());
        billDTO.setReceivingAddress(bill.getReceivingAddress());
        billDTO.setTotalAmount(bill.getTotalAmount());
        billDTO.setOrderDate(bill.getOrderDate());
        billDTO.setCreateAt(bill.getCreateAt());
        billDTO.setUpdateAt(bill.getUpdateAt());
        return billDTO;
    }

    public BillDetails convertToBillDetails(BillDetailsDTO billDetailsDTO){
        BillDetails billDetails = new BillDetails();
        billDetails.setId(billDetailsDTO.getBillDetailsId());
        billDetails.setPrice(billDetailsDTO.getPrice());
        billDetails.setQuantity(billDetailsDTO.getQuantity());
        billDetails.setCreateAt(billDetailsDTO.getCreateAt());
        billDetails.setUpdateAt(billDetailsDTO.getUpdateAt());
        return billDetails;
    }

    public BillDetailsDTO convertToBillDetailsDTO(BillDetails billDetails){
        BillDetailsDTO billDetailsDTO = new BillDetailsDTO();
        billDetailsDTO.setBillDetailsId(billDetails.getId());
        billDetailsDTO.setPrice(billDetails.getPrice());
        billDetailsDTO.setQuantity(billDetails.getQuantity());
        billDetailsDTO.setCreateAt(billDetails.getCreateAt());
        billDetailsDTO.setUpdateAt(billDetails.getUpdateAt());
        return billDetailsDTO;
    }

    public Category convertToCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setCreateAt(categoryDTO.getCreateAt());
        category.setUpdateAt(categoryDTO.getUpdateAt());
        return category;
    }

    public CategoryDTO convertToCategoryDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setCreateAt(category.getCreateAt());
        categoryDTO.setUpdateAt(category.getUpdateAt());
        return categoryDTO;
    }

    public User convertToUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getUserId());
        user.setName(userDTO.getName());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setCreateAt(userDTO.getCreateAt());
        user.setUpdateAt(userDTO.getUpdateAt());
        return user;
    }

    public UserDTO convertToUserDTO(User user){
        UserDTO useDTO = new UserDTO();
        useDTO.setUserId(user.getId());
        useDTO.setName(user.getName());
        useDTO.setUserName(user.getUsername());
        useDTO.setPassword(user.getPassword());
        useDTO.setCreateAt(user.getCreateAt());
        useDTO.setUpdateAt(user.getUpdateAt());
        return useDTO;
    }
}
