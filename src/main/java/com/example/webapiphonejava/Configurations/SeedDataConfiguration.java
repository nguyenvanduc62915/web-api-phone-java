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
    Category category_1 = new Category();
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
    Product product_2 = new Product();
    Product product_3 = new Product();
    Bill bill_1 = new Bill(1, LocalDate.now(), 2000.00, "Số 16 Ngõ 512 An Dương Vương - Đông Ngạc - Bắc Từ Liêm - Hà Nội", "Giao vào giờ hành chính", customer_1, condition_1, shipper_1, null);
    Bill bill_2 = new Bill(2, LocalDate.now(), 1700.00, "Đại học Bách Khoa Hà Nội", "Giao vào giờ hành chính", customer_2, condition_2, shipper_2, null);
    Bill bill_3 = new Bill(3, LocalDate.now(), 4000.00, "Ngã số 3 Nhật Chiêu - Nhật Tân - Tây Hồ - Hà Nội", "Giao vào chiều tối", customer_3, condition_3, shipper_3, null);
    BillDetails billDetails_1 = new BillDetails(1, 2, 1000.0, bill_1, product_1);
    BillDetails billDetails_1 = new BillDetails(2, 1, 1700.0, bill_2, product_2);
    BillDetails billDetails_1 = new BillDetails(3, 1, 4000.0, bill_3, product_3);
    private void seedDataBill() {
        billRepository.saveAll(List.of(bill_1, bill_2, bill_3));
    }

    private void seedDataBillDetails() {
    }

    private void seedDataCategory() {
    }

    private void seedDataComment() {
    }

    private void seedDataCondition() {
    }

    private void seedDataCustomer() {
    }

    private void seedDataOrder() {
    }

    private void seedDataProduct() {
    }

    private void seedDataProductsOfSale() {
    }

    private void seedDataShipper() {
    }

    private void seedDataUser() {
    }
}
