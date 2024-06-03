package com.example.webapiphonejava.Utils;

import com.example.webapiphonejava.DTO.*;
import com.example.webapiphonejava.Models.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConvertRelationship {
    public Bill convertToBill(BillDTO billDTO) {
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

    public BillDTO convertToBillDTO(Bill bill) {
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

    public BillDetails convertToBillDetails(BillDetailsDTO billDetailsDTO) {
        BillDetails billDetails = new BillDetails();
        billDetails.setId(billDetailsDTO.getBillDetailsId());
        billDetails.setPrice(billDetailsDTO.getPrice());
        billDetails.setQuantity(billDetailsDTO.getQuantity());
        billDetails.setCreateAt(billDetailsDTO.getCreateAt());
        billDetails.setUpdateAt(billDetailsDTO.getUpdateAt());
        return billDetails;
    }

    public BillDetailsDTO convertToBillDetailsDTO(BillDetails billDetails) {
        BillDetailsDTO billDetailsDTO = new BillDetailsDTO();
        billDetailsDTO.setBillDetailsId(billDetails.getId());
        billDetailsDTO.setPrice(billDetails.getPrice());
        billDetailsDTO.setQuantity(billDetails.getQuantity());
        billDetailsDTO.setCreateAt(billDetails.getCreateAt());
        billDetailsDTO.setUpdateAt(billDetails.getUpdateAt());
        return billDetailsDTO;
    }

    public Category convertToCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setCreateAt(categoryDTO.getCreateAt());
        category.setUpdateAt(categoryDTO.getUpdateAt());
        return category;
    }

    public CategoryDTO convertToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setCreateAt(category.getCreateAt());
        categoryDTO.setUpdateAt(category.getUpdateAt());
        return categoryDTO;
    }

    public Comment convertToComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(commentDTO.getCommentId());
        comment.setFullName(commentDTO.getFullName());
        comment.setPhone(commentDTO.getPhone());
        comment.setContent(commentDTO.getContent());
        comment.setDateAndTime(commentDTO.getDateAndTime());
        comment.setCreateAt(commentDTO.getCreateAt());
        comment.setUpdateAt(commentDTO.getUpdateAt());
        return comment;
    }

    public CommentDTO convertToCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(comment.getId());
        commentDTO.setFullName(comment.getFullName());
        commentDTO.setPhone(comment.getPhone());
        commentDTO.setContent(comment.getContent());
        commentDTO.setDateAndTime(comment.getDateAndTime());
        commentDTO.setCreateAt(comment.getCreateAt());
        commentDTO.setUpdateAt(comment.getUpdateAt());
        return commentDTO;
    }

    public Condition converToCondition(ConditionDTO conditionDTO) {
        Condition condition = new Condition();
        condition.setId(conditionDTO.getConditionId());
        condition.setOrderStatus(conditionDTO.getOrderStatus());
        condition.setCreateAt(conditionDTO.getCreateAt());
        condition.setUpdateAt(conditionDTO.getUpdateAt());
        return condition;
    }

    public ConditionDTO convertToConditionDTO(Condition condition) {
        ConditionDTO conditionDTO = new ConditionDTO();
        conditionDTO.setConditionId(condition.getId());
        conditionDTO.setOrderStatus(condition.getOrderStatus());
        conditionDTO.setCreateAt(condition.getCreateAt());
        conditionDTO.setUpdateAt(condition.getUpdateAt());
        return conditionDTO;
    }

    public Customer convertToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getCustomerId());
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setCreateAt(customerDTO.getCreateAt());
        customer.setUpdateAt(customerDTO.getUpdateAt());
        return customer;
    }

    public CustomerDTO convertToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getId());
        customerDTO.setCustomerName(customer.getCustomerName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setCreateAt(customer.getCreateAt());
        customerDTO.setUpdateAt(customer.getUpdateAt());
        return customerDTO;
    }

    public Order converToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getOrderId());
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setCreateAt(orderDTO.getCreateAt());
        order.setUpdateAt(orderDTO.getUpdateAt());
        return order;
    }

    public OrderDTO converToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getId());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setCreateAt(order.getCreateAt());
        orderDTO.setUpdateAt(order.getUpdateAt());
        return orderDTO;
    }

    public Product convertToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getProductId());
        product.setPrice(productDTO.getPrice());
        product.setAmount(productDTO.getAmount());
        product.setCamera(productDTO.getCamera());
        product.setBattery(productDTO.getBattery());
        product.setColor(productDTO.getColor());
        product.setConnection(productDTO.getConnection());
        product.setWeight(productDTO.getWeight());
        product.setWarranty(productDTO.getWarranty());
        product.setStartSale(productDTO.getStartSale());
        product.setSound(productDTO.getSound());
        product.setSale(productDTO.getSale());
        product.setProductName(productDTO.getProductName());
        product.setProductImage(productDTO.getProductImage());
        product.setOperatingSystem(productDTO.getOperatingSystem());
        product.setMemoryCard(productDTO.getMemoryCard());
        product.setMemory(productDTO.getMemory());
        product.setEndSale(productDTO.getEndSale());
        product.setDimension(productDTO.getDimension());
        product.setCreateAt(productDTO.getCreateAt());
        product.setUpdateAt(productDTO.getUpdateAt());
        return product;
    }

    public ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setAmount(product.getAmount());
        productDTO.setCamera(product.getCamera());
        productDTO.setBattery(product.getBattery());
        productDTO.setColor(product.getColor());
        productDTO.setConnection(product.getConnection());
        productDTO.setWeight(product.getWeight());
        productDTO.setWarranty(product.getWarranty());
        productDTO.setStartSale(product.getStartSale());
        productDTO.setSound(product.getSound());
        productDTO.setSale(product.getSale());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductImage(product.getProductImage());
        productDTO.setOperatingSystem(product.getOperatingSystem());
        productDTO.setMemoryCard(product.getMemoryCard());
        productDTO.setMemory(product.getMemory());
        productDTO.setEndSale(product.getEndSale());
        productDTO.setDimension(product.getDimension());
        productDTO.setCreateAt(product.getCreateAt());
        productDTO.setUpdateAt(product.getUpdateAt());
        return productDTO;
    }

    public ProductsOfSale convertToProductsOfSale(ProductsOfSaleDTO productsOfSaleDTO) {
        ProductsOfSale productsOfSale = new ProductsOfSale();
        productsOfSale.setId(productsOfSaleDTO.getProductOrSaleId());
        productsOfSale.setQuantity(productsOfSaleDTO.getQuantity());
        productsOfSale.setCreateAt(productsOfSaleDTO.getCreateAt());
        productsOfSale.setUpdateAt(productsOfSaleDTO.getUpdateAt());
        return productsOfSale;
    }

    public ProductsOfSaleDTO convertToProductsOfSaleDTO(ProductsOfSale productsOfSale) {
        ProductsOfSaleDTO productsOfSaleDTO = new ProductsOfSaleDTO();
        productsOfSaleDTO.setProductOrSaleId(productsOfSale.getId());
        productsOfSaleDTO.setQuantity(productsOfSale.getQuantity());
        productsOfSaleDTO.setCreateAt(productsOfSale.getCreateAt());
        productsOfSaleDTO.setUpdateAt(productsOfSale.getUpdateAt());
        return productsOfSaleDTO;
    }

    public Shipper convertToShipper(ShipperDTO shipperDTO) {
        Shipper shipper = new Shipper();
        shipper.setId(shipperDTO.getShipperId());
        shipper.setShipperName(shipperDTO.getShipperName());
        shipper.setPhoneShipperOne(shipperDTO.getPhoneShipperOne());
        shipper.setPhoneShipperTwo(shipperDTO.getPhoneShipperTwo());
        shipper.setCreateAt(shipperDTO.getCreateAt());
        shipper.setUpdateAt(shipperDTO.getUpdateAt());
        return shipper;
    }

    public ShipperDTO convertToShipperDTO(Shipper shipper) {
        ShipperDTO shipperDTO = new ShipperDTO();
        shipperDTO.setShipperId(shipper.getId());
        shipperDTO.setShipperName(shipper.getShipperName());
        shipperDTO.setPhoneShipperOne(shipper.getPhoneShipperOne());
        shipperDTO.setPhoneShipperTwo(shipper.getPhoneShipperTwo());
        shipperDTO.setCreateAt(shipper.getCreateAt());
        shipperDTO.setUpdateAt(shipper.getUpdateAt());
        return shipperDTO;
    }

    public User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getUserId());
        user.setName(userDTO.getName());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setCreateAt(userDTO.getCreateAt());
        user.setUpdateAt(userDTO.getUpdateAt());
        return user;
    }

    public UserDTO convertToUserDTO(User user) {
        UserDTO useDTO = new UserDTO();
        useDTO.setUserId(user.getId());
        useDTO.setName(user.getName());
        useDTO.setUserName(user.getUserName());
        useDTO.setPassword(user.getPassword());
        useDTO.setCreateAt(user.getCreateAt());
        useDTO.setUpdateAt(user.getUpdateAt());
        return useDTO;
    }
}
