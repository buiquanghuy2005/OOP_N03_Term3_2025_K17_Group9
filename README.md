Project 09[Dự án 09]. Xây dựng ứng dụng quản lý Đội Bóng.

Yêu cầu chính :
Giao diện Java Spring Boot
Chức năng:
+)Quản lý cầu thủ
+)Quản lý câu lạc bộ(CLB)
+)Gán cầu thủ vào câu lạc bộ

Cụ thể : 
1.Quản lý cầu thủ
-Thông tin cầu thủ: Mã cầu thủ, họ tên, tuổi, vị trí, quốc tịch,...
-Chức năng:
+)Thêm cầu thủ
+)Sửa thông tin cầu thủ
+)Xóa cầu thủ
+)Liệt kê cầu thủ
+)Lọc cầu thủ theo độ tuổi, vị trí hoặc quốc tịch
2. Quản lý câu lạc bộ (CLB)
-Thông tin CLB: Mã CLB, tên CLB, HLV trưởng, sân vận động,...
-Chức năng:
+)Thêm CLB
+)Sửa thông tin CLB
+)Xóa CLB
3. Gán cầu thủ cho CLB
-Mỗi cầu thủ thuộc về 1 CLB
-Hiển thị danh sách cầu thủ theo từng CLB

4.Lưu trữ và xử lý dữ liệu
Tạo các class CauThu, CLB, DanhSachCauThu, DanhSachCLB
Lưu dữ liệu xuống file nhị phân (ObjectOutputStream, ObjectInputStream)
Đọc dữ liệu khi ứng dụng khởi chạy
Sử dụng ArrayList<CauThu> và Map<CLB, List<CauThu>> để quản lý trong bộ nhớ.






