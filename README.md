## Thông Tin Dự Án

- **Lớp học phần:** 420300362101  
- **Môn học:** Lập trình WWW (Java)  
- **Giảng viên hướng dẫn:** Võ Văn Hải  
- **Sinh viên thực hiện:** Nguyễn Kiến Thức  
- **MSSV:** 21038611  

---

## 📋 Tài Liệu Báo Cáo
- Word: [Báo Cáo Đồ Án](document/21038611_NguyenKienThuc_Report_WWW_LabWeek05.docx)
- PowerPoint: [Slide Thuyết Trình](document/21038611_NguyenKienThuc_Slides_WWW_LabWeek05.pptx)

---

## 🎯 Mục Tiêu
- Kết nối ứng viên và nhà tuyển dụng một cách hiệu quả.
- Cung cấp các tính năng quản lý công việc, ứng viên, công ty và gợi ý phù hợp.
- Hỗ trợ gửi thông báo cơ hội việc làm qua email.
- Tối ưu hóa trải nghiệm và tiết kiệm thời gian cho cả ứng viên và nhà tuyển dụng.

---

## 💻 Công Nghệ Sử Dụng

- **Ngôn ngữ lập trình:** Java, HTML, CSS, JavaScript  
- **Backend Framework:** Spring Boot  
- **Template Engine:** Thymeleaf  
- **Quản lý cơ sở dữ liệu:** Jakarta Persistence API (JPA), MariaDB  
- **Giao diện:** Bootstrap  
- **Quản lý phụ thuộc:** Gradle  
- **Thư viện hỗ trợ:** Lombok, JavaMail  

---

## 🔑 Chức Năng Chính

### 1. Quản lý ứng viên
- **Thêm, sửa, tìm kiếm ứng viên.**
- **Gợi ý kỹ năng:** Đề xuất kỹ năng cần cải thiện.  
- **Gợi ý công việc:** Công việc phù hợp dựa trên kỹ năng.  

### 2. Quản lý công việc
- **Thêm, tìm kiếm công việc.**
- **Thông tin chi tiết:** Hiển thị yêu cầu công việc, công ty liên quan.  

### 3. Quản lý công ty
- **Quản lý thông tin:** xem công ty và danh sách công việc.  
- **Gợi ý ứng viên:** Phân tích yêu cầu và gợi ý ứng viên phù hợp.  

### 4. Gửi email
- Gửi email cơ hội việc làm tới ứng viên.
- Gửi email ứng tuyển tới nhà tuyển dụng.

---
## 🔭 Thiết Kế Hệ Thống

- **Sơ đồ cơ sở dữ liệu:** Quản lý thông tin ứng viên, công việc, công ty, kỹ năng và liên kết giữa chúng.
 ![image](https://github.com/user-attachments/assets/5249fabf-cea0-470b-9b30-bc8cf1a6b53f)

- **Biểu đồ lớp:** Mô tả mối quan hệ giữa các thành phần trong hệ thống.
![image](https://github.com/user-attachments/assets/147f60bd-4d57-4f44-8e78-c2de8c844781)

---


 ## 🖥️ Giao Diện Ứng Dụng

### **1. Giao diện chính**
Giao diện chính của ứng dụng bao gồm thanh điều hướng, tìm kiếm nhanh, và danh sách công việc hoặc ứng viên. Người dùng có thể truy cập các phần Quản lý công việc, Ứng viên, Công ty qua menu.

![image](https://github.com/user-attachments/assets/0b1c0689-6e6d-40cd-a709-ed08eedb04b2)

---

### **2. Giao diện Candidates**

- **Giao diện chính Candidates**  
Hiển thị danh sách ứng viên với các nút chức năng như thêm, chỉnh sửa, đề xuất công việc và đề xuất kỹ năng. Danh sách hỗ trợ tìm kiếm nhanh.

 ![image](https://github.com/user-attachments/assets/76031384-4818-448e-bfa0-aacf944b2bc0)
 
   Sau khi tìm kiếm một ứng viên cụ thể

  ![image](https://github.com/user-attachments/assets/66422249-048b-43e7-8f70-a12f49e4b861)

- **Giao diện thêm ứng viên**  
Cung cấp biểu mẫu để nhập thông tin ứng viên mới bao gồm tên, ngày sinh, email, phone, địa chỉ và Zipcode.

 ![image](https://github.com/user-attachments/assets/05681eac-e86e-4d55-b9a6-b42cebc8e921)

  
- **Giao diện cập nhật thông tin ứng viên**  
Cho phép chỉnh sửa thông tin đã lưu của ứng viên như tên, ngày sinh, email, phone, địa chỉ và Zipcode.

 ![image](https://github.com/user-attachments/assets/6ee11a9b-3b4a-452a-acf4-c815868db4cc)


- **Giao diện đề xuất công việc cho ứng viên**  
Hiển thị các công việc phù hợp dựa trên kỹ năng và hồ sơ của ứng viên và ứng viên có thể gửi email ứng tuyển tại giao diện này

![image](https://github.com/user-attachments/assets/119f60a9-a895-4c21-af9a-b0fe8c2bb05a)


- **Giao diện đề xuất kỹ năng cho ứng viên**  
Gợi ý kỹ năng cần cải thiện để ứng viên đáp ứng tốt hơn các yêu cầu công việc.

 ![image](https://github.com/user-attachments/assets/085c1ef4-d75f-4297-9ec9-7eebd5b2ffac)


---

### **3. Giao diện Jobs**

- **Giao diện chính của Jobs**  
Hiển thị danh sách công việc với tùy chọn xem thêm thông tin về công ty đang tuyển dụng công việc đó. Danh sách hỗ trợ tìm kiếm theo tên hoặc kỹ năng yêu cầu.

![image](https://github.com/user-attachments/assets/7955bd74-6b42-4c68-9b9f-5f1e97a656be)

Sau khi tìm kiếm một công việc theo một tiêu chí cụ thể

![image](https://github.com/user-attachments/assets/dc0f152b-46fc-4e1c-a9ae-40a502f019a5)

- **Giao diện thêm mới Jobs**  
Cho phép nhà tuyển dụng tạo công việc mới với thông tin chi tiết về mô tả và kỹ năng yêu cầu. Giao diện này được mở thông qua giao diện của company khi người dùng nhấn vào xem thông tin thêm của công ty cụ thể

![image](https://github.com/user-attachments/assets/f4e573ca-8e40-46a1-8e1d-32bf64fcea65)

- **Giao diện thông tin công việc và ứng viên phù hợp**  
Hiển thị chi tiết công việc và danh sách ứng viên phù hợp với yêu cầu. Giao diện này được mở tương tự như phần thêm Jobs. Công ty có thể gửi email cho các ứng viên phù hợp ở giao diện này

 ![image](https://github.com/user-attachments/assets/05139123-2933-4f96-a16a-8bfb045cc125)

---

### **4. Giao diện Companies**

- **Giao diện chính Companies**  
Hiển thị danh sách công ty và các tùy chọn tìm kiếm, xem chi tiết thông tin công ty cũng như các công việc công ty đang tuyển.

![image](https://github.com/user-attachments/assets/203a2e0d-1d96-4a6f-99a0-7724af642cd1)

Sau khi tìm kiếm theo một tiêu chí cụ thể

![image](https://github.com/user-attachments/assets/f596102c-fff9-4b38-92b1-67064887da1c)


- **Giao diện thông tin chi tiết công ty**  
Hiển thị thông tin chi tiết về công ty và các công việc đang tuyển dụng. Công ty có thể thêm công việc hoặc đề xuất các ứng viên phù hợp với các công việc của công ty tại đây. Ngoài ra ứng viên cũng có thể gửi email ứng tuyển tại đây

![image](https://github.com/user-attachments/assets/f70a765c-3cad-4182-b0d7-4fcc61d2e423)

---

### **5. Giao diện gửi email**

- **Gửi email cho ứng viên**  
Cho phép nhà tuyển dụng gửi email thông báo công việc đến ứng viên.

 ![image](https://github.com/user-attachments/assets/ed336a8d-ed3f-4e36-81ab-5f74c6583d09)


- **Gửi email ứng tuyển cho công ty**  
Ứng viên có thể gửi email ứng tuyển đến các công ty phù hợp.

![image](https://github.com/user-attachments/assets/7a346a39-4ab2-45dd-b614-a52ccb4553f2)


---

---


## 📌 Kết luận

Trong quá trình thực hiện đề tài "Ứng dụng hỗ trợ tìm kiếm việc làm và tuyển dụng," hệ thống đã được xây dựng thành công, đáp ứng hiệu quả các yêu cầu cơ bản về kết nối ứng viên và nhà tuyển dụng. Hệ thống cung cấp các tính năng quản lý danh sách công việc, ứng viên và công ty, đồng thời tích hợp các chức năng thông minh như gợi ý công việc, gợi ý kỹ năng và gửi email tự động, giúp tối ưu hóa quy trình tuyển dụng và tìm việc.

Ứng dụng được phát triển dựa trên các công nghệ tiên tiến như **Spring Boot**, **Thymeleaf**, **Bootstrap**, và **Jakarta Persistence API (JPA)**, đảm bảo khả năng mở rộng, bảo trì dễ dàng và hiệu năng cao. Giao diện thân thiện, được thiết kế với Bootstrap, hỗ trợ người dùng thao tác thuận tiện.

Tuy nhiên, hệ thống hiện tại vẫn còn một số hạn chế:
- **Chưa tích hợp thuật toán Machine Learning (ML):** Điều này ảnh hưởng đến khả năng gợi ý thông minh và tối ưu hóa các kết quả gợi ý.
- **Hiệu suất cần cải thiện:** Khi số lượng người dùng tăng lên đáng kể.

### Định hướng phát triển trong tương lai:
- **Tích hợp trí tuệ nhân tạo (AI):** Cải thiện tính chính xác và thông minh trong việc gợi ý công việc và kỹ năng cho người dùng.
- **Phát triển ứng dụng di động:** Tăng cường tính tiện lợi cho người dùng trên nền tảng Android/iOS.
- **Hỗ trợ đa ngôn ngữ:** Tiếp cận đối tượng người dùng quốc tế, mở rộng phạm vi ứng dụng.
- **Nâng cấp giao diện người dùng:** Sử dụng các công nghệ hiện đại như **React** hoặc **Vue.js** để cải thiện trải nghiệm người dùng.
- **Tăng cường bảo mật:** Áp dụng các biện pháp bảo mật mạnh mẽ hơn để bảo vệ dữ liệu người dùng.
- **Tối ưu hóa hiệu suất:** Đảm bảo hệ thống hoạt động ổn định và hiệu quả với lượng người dùng lớn.

Kết luận, đề tài đã đạt được các mục tiêu đặt ra ban đầu, mang lại giải pháp hữu ích trong việc kết nối cơ hội việc làm và tuyển dụng. Hệ thống đã đặt nền tảng vững chắc cho các cải tiến và mở rộng trong tương lai, hướng đến việc đáp ứng tốt hơn nhu cầu của cả ứng viên và nhà tuyển dụng.


---

