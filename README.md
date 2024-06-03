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
- Step 3: Mở Terminal trên IntelliJ IDEA hoặc ẩn tổ hợp phím "Alt + F12" gõ lệnh
```mvn
    ./mvnw spring-boot:run
```
- Step 4: Đợi 1 lúc để chương trình xây dựng Databasse
- Step 5: Mở Postman lên nhập đường dẫn ở Controller sau đó test API
## Cấu trúc của thư mục nguồn
GitHib: <https://github.com/nguyenvanduc62915/web-api-phone-java>
```dos
|   Readme.docx
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
|   |   |   |   ├───Configuarations
|   |   |   |   |   |
|   |   |   |   |   | SeedDataConfiguaration ( File này có chức năng tạo Database ban đầu )
|   |   |   |   |   |
|   |   |   |   ├───Controllers 
|   |   |   |   |   |
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
|   |   |   |   ├───DTO
|   |   |   |   |   |
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
|   |   |   |   ├───Exception
|   |   |   |   |   |
|   |   |   |   |   |   ValidateExceptionHandler
|   |   |   |   |   |
|   |   |   |   ├───Models          ( File này đại diện cấu trúc dữ liệu của dự án )            
|   |   |   |   |   |
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
|   |   |   |   ├───Repositories
|   |   |   |   |   |
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
|   |   |   |   ├───Services
|   |   |   |   |   |
|   |   |   |   |   |   BillSerivce
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
|   |   |   |   ├───Utils
|   |   |   |   |   |
|   |   |   |   |   |   Contstant
|   |   |   |   |   |   ConvertRelationship
|   |   |   |   |   |
|   |   |   |   ├───WebApiPhoneJavaApplication
```