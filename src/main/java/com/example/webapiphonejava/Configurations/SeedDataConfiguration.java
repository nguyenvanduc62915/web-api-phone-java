package com.example.webapiphonejava.Configurations;

import com.example.webapiphonejava.Models.*;
import com.example.webapiphonejava.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class SeedDataConfiguration {
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillDetailsRepository billDetailsRepository;

    @Autowired
    private CategorRepository categorRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ConditionRepository conditionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductsOfSaleRepository productsOfSaleRepository;

    @Autowired
    private ShipperRepository shipperRepository;

    @Autowired
    private UserRepository userRepository;

    private boolean isSeedData = false;

    @Bean
    public CommandLineRunner seedData() {
        return args -> {
            if (!isSeedData) {
                seedDataBill();
                seedDataBillDetails();
                seedDataCategory();
                seedDataComment();
                seedDataCondition();
                seedDataCustomer();
                seedDataOrder();
                seedDataProduct();
                seedDataProductsOfSale();
                seedDataProductsOfSale();
                seedDataShipper();
                seedDataUser();
                isSeedData = true;
            }
        };
    }
    Order order_1 = new Order(1, "Còn hàng");
    Order order_2 = new Order(2, "Còn hàng");
    Order order_3 = new Order(3, "Hết hàng");
    Category category_1 = new Category(1, "Đồ ăn nhanh", null);
    Category category_2 = new Category(2, "Đồ khô", null);
    Category category_3 = new Category(3, "Sữa", null);
    Condition condition_1 = new Condition(1, "Sản phẩm tốt", null);
    Condition condition_2 = new Condition(2, "Chất lượng", null);
    Condition condition_3 = new Condition(3, "Điện thoại rẻ, chất lượng", null);
    Customer customer_1 = new Customer(1, "Nguyễn Văn Đức", "0944591191", "duc@gmail.com", null);
    Customer customer_2 = new Customer(2, "Nguyễn Thành Đạt", "0922125123", "dat@gmail.com", null);
    Customer customer_3 = new Customer(3, "Phạm Ngọc Khánh", "0888152142", "khanh@gmail.com", null);
    Shipper shipper_1 = new Shipper(1, "Lê Văn Hiếu", "0289591181", "0189591182", null);
    Shipper shipper_2 = new Shipper(2, "Dương Ngọc Tỉnh", "0689591183", "0389591184", null);
    Shipper shipper_3 = new Shipper(3, "Phạm Đình Trường", "0589591183", "0389591152", null);
    Product product_1 = new Product(1, "Iphone 10", 1, 1, 1, "143,6 x 70,9 x 7,7 mm", "129g", "Màu đen", "Stereo", "256gb", "IOS 17", "3b", "7MP, f/2.2", "2716mAh", "2 năm", "Có 1 cổng typeC", 0, null, null, category_1, null, null, null);
    Product product_2 = new Product(2, "Iphone 10", 1, 1, 1, "143,6 x 70,9 x 7,7 mm", "129g", "Màu đen", "Stereo", "512gb", "IOS 17", "3b", "7MP, f/2.2", "2716mAh", "2 năm", "Có 1 cổng typeC", 0, null, null, category_2, null, null, null);
    Product product_3 = new Product(3, "Iphone 10", 1, 1, 1, "143,6 x 70,9 x 7,7 mm", "129g", "Màu đen", "Stereo", "1T", "IOS 17", "3b", "7MP, f/2.2", "2716mAh", "2 năm", "Có 1 cổng typeC", 0, null, null, category_3, null, null, null);
    Comment comment_1 = new Comment(1, "Hoàng Hữu Thành", LocalDate.now(), "Shop có cơ sở ở miền Bắc không?", "0886862231", product_1);
    Comment comment_2 = new Comment(2, "Hoàng Văn Thành", LocalDate.now(), "Shop có cơ sở ở Hải phòng không?", "0186862232", product_2);
    Comment comment_3 = new Comment(3, "Vũ Thị Thắm", LocalDate.now(), "Shop có cơ sở ở miền Nam không?", "0776862236", product_3);
    Bill bill_1 = new Bill(1, LocalDate.now(), 2000.00, "Số 16 Ngõ 512 An Dương Vương - Đông Ngạc - Bắc Từ Liêm - Hà Nội", "Giao vào giờ hành chính", customer_1, condition_1, shipper_1, null);
    Bill bill_2 = new Bill(2, LocalDate.now(), 1700.00, "Đại học Bách Khoa Hà Nội", "Giao vào giờ hành chính", customer_2, condition_2, shipper_2, null);
    Bill bill_3 = new Bill(3, LocalDate.now(), 4000.00, "Ngã số 3 Nhật Chiêu - Nhật Tân - Tây Hồ - Hà Nội", "Giao vào chiều tối", customer_3, condition_3, shipper_3, null);
    BillDetails billDetails_1 = new BillDetails(1, 2, 1000.0, bill_1, product_1);
    BillDetails billDetails_2 = new BillDetails(2, 1, 1700.0, bill_2, product_2);
    BillDetails billDetails_3 = new BillDetails(3, 1, 4000.0, bill_3, product_3);
    ProductsOfSale productsOfSale_1 = new ProductsOfSale(1, 1, product_1);
    ProductsOfSale productsOfSale_2 = new ProductsOfSale(2, 2, product_2);
    ProductsOfSale productsOfSale_3 = new ProductsOfSale(3, 2, product_3);
    User user_1  = new User(1,  "Nguyễn Văn Đức", "nguyenvanduc2k3", "0993337423", Role.ADMIN);
    User user_2  = new User(2,  "Nguyễn Thành Đạt", "datvup123", "datvippro", Role.USER);
    User user_3  = new User(3,  "Nguyễn Văn Thọ", "thoyeuhuong", "vuthanhhuong", Role.USER);
    private void seedDataBill() {
        billRepository.saveAll(List.of(bill_1, bill_2, bill_3));
    }

    private void seedDataBillDetails() {
        billDetailsRepository.saveAll(List.of(billDetails_1, billDetails_2, billDetails_3));
    }

    private void seedDataCategory() {
        categorRepository.saveAll(List.of(category_1, category_2, category_3));
    }

    private void seedDataComment() {
        commentRepository.saveAll(List.of(comment_1, comment_2, comment_3));
    }

    private void seedDataCondition() {
        conditionRepository.saveAll(List.of(condition_1, condition_2, condition_3));
    }

    private void seedDataCustomer() {
        customerRepository.saveAll(List.of(customer_1, customer_2, customer_3));
    }

    private void seedDataOrder() {
        orderRepository.saveAll(List.of(order_1, order_2, order_3));
    }

    private void seedDataProduct() {
        productRepository.saveAll(List.of(product_1, product_2, product_3));
    }

    private void seedDataProductsOfSale() {
        productsOfSaleRepository.saveAll(List.of(productsOfSale_1,  productsOfSale_2, productsOfSale_3));
    }

    private void seedDataShipper() {
        shipperRepository.saveAll(List.of(shipper_1, shipper_2, shipper_3));
    }

    private void seedDataUser() {
        userRepository.saveAll(List.of(user_1, user_2, user_3));
    }
}
