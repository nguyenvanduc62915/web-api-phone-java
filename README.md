# Course Dependency
## Tổng quan
Project làm về Web APIs về đề tài quản lý cửa hàng điện thoại
## Điều kiện tiên quyết
### Cài đặt Java SE 17.0.8:
- Step 1: Tải JDK bằng PowerShell
```powershell
    $url = "https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.exe"
    $output = "$env:HOMEPATH\Downloads\jdk-17.0.8_windows-x64_bin.exe"
    Invoke-WebRequest -Uri $url -OutFile $output
```
- Step 2: Cài đặt JDK
```powershell
    %HOMEPATH%\Downloads\jdk-17.0.8_windows-x64_bin.exe
```
- Step 3: Thiết lập biến môi trường
```powershell
    setx PATH "%PATH%;C:\Program Files\Java\jdk-17.0.8\bin"
```
- Step 4: Kiểm tra cài đặt
```powershell
    java -version
```
### Cài đặt IDE (Em dùng IntelliJ IDEA 2023.2.1):
- Step 1: Tải IntelliJ IDEA bằng PowerShell
```powershell
    $url = "https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.exe"
    $output = "$env:HOMEPATH\Downloads\jdk-17.0.8_windows-x64_bin.exe"
    Invoke-WebRequest -Uri $url -OutFile $output
```
- Step 2: Cài đặt IntelliJ IDEA
```powershell
    %HOMEPATH%\Downloads\ideaIC-2023.2.1.exe
```
- Step 3: Thiết lập biến môi trường
```powershell
    setx PATH "%PATH%;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.1\bin"
```
### Cài đặt SQL (Em dùng MySQL Workbench 8.0 CE):
- Step 1: Tải MySQL Workbench 8.0 CE
```cmd
    powershell -Command "Invoke-WebRequest -Uri 'https://dev.mysql.com/get/Downloads/MySQLGUITools/mysql-workbench-community-8.0.33-winx64.msi' -OutFile '%HOMEPATH%\Downloads\mysql-workbench-community-8.0.33-winx64.msi'"
```
- Step 2: Cài đặt MySQL Workbench 8.0 CE
```cmd
    msiexec /i "%HOMEPATH%\Downloads\mysql-workbench-community-8.0.33-winx64.msi" /quiet
```
- Step 3: Thiết lập biến môi trường 
```cmd
    setx PATH "%PATH%;C:\Program Files\MySQL\MySQL Workbench 8.0 CE"
```
- Step 4: Cài đặt MySQL Server
```cmd
    choco install mysql -y
```
### Cài đặt công cụ thao tác với API (Em dùng Postman)
- Step 1: Tải Postman
```cmd
    powershell -Command "Invoke-WebRequest -Uri 'https://dl.pstmn.io/download/latest/win64' -OutFile '%HOMEPATH%\Downloads\Postman-win64-setup.exe'"
```
- Step 2: Cài đặt Postman
```cmd
    %HOMEPATH%\Downloads\Postman-win64-setup.exe /S
```
## Cách chạy 
- Step 1: Mở MySQL đăng nhập tài khoản mật khẩu máy và tạo 1 tên cơ sở dữ liệu
- Step 2: Mở Proejct trên IntelliJ IDEA vào file src -> main -> resources -> application.yml chỉnh sửa tài khoản mật khẩu MySQL và đường dẫn vừa tạo tên cơ sở dữ liệu trên máy
```yml    
    url: jdbc:mysql://localhost:3306/....
    username: ....
    password: ....
```
Lưu ý: đường dẫn phải đúng tên cơ sở dữ liệu vừa tạo và phải đúng tài khoản mật khẩu MySQL trên máy
- Step 3: 
  - Ấn tổ hợp phím "Shift + F10" (Khuyến khích chạy bằng cách này)
  - Hoặc vào project tìm vào src -> main -> java -> com.example.webapiphonejava -> WebApiPhoneJavaApplication (Khuyến khích chạy bằng cách này)
```dos
├───src                             
|   ├───main
|   |   ├───java
|   |   |   ├───com.example.wedapiphonejava
|   |   |   |   ├───WebApiPhoneJavaApplication (File Main của chương trình)
```
  - Mở Terminal trên IntelliJ IDEA hoặc ẩn tổ hợp phím "Alt + F12" gõ lệnh "./mvnw spring-boot:run" (Không khuyến khích dùng cách này do sẽ dễ xảy ra lỗi  org.apache.maven.plugins:maven-compiler-plugin:3.11.0:compile )
```mvn
    ./mvnw spring-boot:run
```
- Step 4: Đợi 1 lúc để chương trình xây dựng Databasse
- Step 5: Mở Postman lên nhập đường dẫn ở Controller sau đó test API
## Cấu trúc của thư mục nguồn
GitHib: <https://github.com/nguyenvanduc62915/web-api-phone-java>
```dos
|   Readme.docx                     (Demo và các hình ảnh liên quan đến dự án)
|   README.md                       (Hướng dẫn)
|       
├───.idea                           (File cấu hình môi trường code Intellij IDEA)
|
├───.mvn                            (File này chứa các tệp để khởi động Maven)
|       
├───src                             (File chính chứa code dự án)
|   ├───main
|   |   ├───java
|   |   |   ├───com.example.wedapiphonejava
|   |   |   |   ├───Configuarations ( File này có chức năng cấu hình của dự án )
|   |   |   |   |   |
|   |   |   |   |   | SeedDataConfiguaration ( Database ban đầu của dự án)
|   |   |   |   |   |
|   |   |   |   ├───Controllers ( File này có chức năng quyết định dữ liệu hiển thị như nào )
|   |   |   |   |   |
|   |   |   |   |   |   Các class dưới có nhiệm vụ xử lý CRUD của dự án
|   |   |   |   |   |   BillController 
|   |   |   |   |   |   BillDetailsConttroller
|   |   |   |   |   |   CategoryController
|   |   |   |   |   |   ConditionController
|   |   |   |   |   |   CommentController
|   |   |   |   |   |   CustomerController
|   |   |   |   |   |   OrderController
|   |   |   |   |   |   ProductController
|   |   |   |   |   |   ProductsOfSaleController
|   |   |   |   |   |   ShipperController
|   |   |   |   |   |   UserController
|   |   |   |   |   |
|   |   |   |   ├───DTO ( File này có chức năng giảmn số lần gọi các method giữa các tiến trình )
|   |   |   |   |   |
|   |   |   |   |   |   Các class dưới có nhiệm vụ khai báo dữ liệu khi trả về cho người dùng tránh lộ database gốc 
|   |   |   |   |   |   BillDTO
|   |   |   |   |   |   BillDetailsDTO
|   |   |   |   |   |   CategoryDTO
|   |   |   |   |   |   ConditionDTO
|   |   |   |   |   |   CommentDTO
|   |   |   |   |   |   CustomerDTO
|   |   |   |   |   |   OrderDTO
|   |   |   |   |   |   ProductDTO
|   |   |   |   |   |   ProductsOfSaleDTO
|   |   |   |   |   |   ShipperDTO
|   |   |   |   |   |   UserDTO
|   |   |   |   |   |
|   |   |   |   ├───Exception ( File này có chức năng xử lý các lỗi ngoại lệ )
|   |   |   |   |   |
|   |   |   |   |   |   ValidateExceptionHandler
|   |   |   |   |   |
|   |   |   |   ├───Models  ( File này đại diện cấu trúc dữ liệu của dự án )            
|   |   |   |   |   |
|   |   |   |   |   |   Các class dưới có nhiệm vụ tự sinh ra database cho dự án
|   |   |   |   |   |   Bill
|   |   |   |   |   |   BillDetails
|   |   |   |   |   |   Category
|   |   |   |   |   |   Condition
|   |   |   |   |   |   Comment
|   |   |   |   |   |   Customer
|   |   |   |   |   |   Order
|   |   |   |   |   |   Product
|   |   |   |   |   |   ProductsOfSale
|   |   |   |   |   |   Shipper
|   |   |   |   |   |   User
|   |   |   |   |   |
|   |   |   |   ├───Repositories ( File này có chức năng phục vụ việc truy xuất database )
|   |   |   |   |   |
|   |   |   |   |   |   Các interface dưới có nhiệm vụ truy xuất dữ liệu
|   |   |   |   |   |   Bill
|   |   |   |   |   |   BillDetails
|   |   |   |   |   |   Category
|   |   |   |   |   |   Condition
|   |   |   |   |   |   Comment
|   |   |   |   |   |   Customer
|   |   |   |   |   |   Order
|   |   |   |   |   |   Product
|   |   |   |   |   |   ProductsOfSale
|   |   |   |   |   |   Shipper
|   |   |   |   |   |   User
|   |   |   |   |   |
|   |   |   |   ├───Services ( File này có chức năng xử lý logic trước khi hiển thị )
|   |   |   |   |   ├───Imp  
|   |   |   |   |   |   |
|   |   |   |   |   |   |   Các interface dưới có nhiệm  vụ khai báo các lớp trừu tượng  
|   |   |   |   |   |   |   BillImp
|   |   |   |   |   |   |   BillDetailsImp
|   |   |   |   |   |   |   CategoryImp
|   |   |   |   |   |   |   ConditionImp
|   |   |   |   |   |   |   CommentImp
|   |   |   |   |   |   |   CustomerImp
|   |   |   |   |   |   |   OrderImp
|   |   |   |   |   |   |   ProductImp
|   |   |   |   |   |   |   ProductsOfSaleImp
|   |   |   |   |   |   |   ShipperImp
|   |   |   |   |   |   |   UserImp
|   |   |   |   |   |   |
|   |   |   |   |   |   Các class dưới có nhiệm vụ xử lý logic, nghiệp vụ của dự án
|   |   |   |   |   |   BillSerivce
|   |   |   |   |   |   BillDetailsSerivce
|   |   |   |   |   |   CategorySerivce
|   |   |   |   |   |   ConditionSerivce
|   |   |   |   |   |   CommentSerivce
|   |   |   |   |   |   CustomerSerivce
|   |   |   |   |   |   OrderSerivce
|   |   |   |   |   |   ProductSerivce
|   |   |   |   |   |   ProductsOfSaleSerivce
|   |   |   |   |   |   ShipperSerivce
|   |   |   |   |   |   UserSerivce
|   |   |   |   |   |
|   |   |   |   ├───Utils  ( File này có chức năng làm giảm tải code ở các tầng trên)
|   |   |   |   |   |
|   |   |   |   |   |   Contstant
|   |   |   |   |   |   ConvertRelationship ( Class ngày có chức năng chuyển đổi dữ liệu qua lại cho nhau giữa Models và DTO)
|   |   |   |   |   |
|   |   |   |   ├───WebApiPhoneJavaApplication ( Khởi động một ứng dụng spring boot khi gọi nó )
|   |   |   |   |
|   |   |   ├───resources
|   |   |   |   |
|   |   |   |   |   static
|   |   |   |   |   templates 
|   |   |   |   |   application.properties ( File này có chức năng cấu hình dự án theo chuẩn properties)
|   |   |   |   |   application.yml ( File này có chức năng cấu hình dự án theo chuẩn yml)
|   |   |   |   |
├───mwnw ( File này có chức năng tài và cài đặt Apache Maven nếu chưa cài đặt trên hệ thống sau đó chạy Maven)
|   |   |   |   |
├───mvnw.cmd (  File này có chức năng đảm bảo Apache Maven có sẵn và được sử dụng trong hệ thống )
|   |   |   |   |
├───pom.xml (  File  trung tâm của dự án có chức năng cấu hình mà Maven xử lý)
|   |   |   |   |
```
## Demo
Link <https://husteduvn-my.sharepoint.com/personal/duc_nv210134p_sis_hust_edu_vn/_layouts/15/doc.aspx?sourcedoc={5c716eda-e22c-443a-b2a5-7eb321ab746c}&action=edit>
