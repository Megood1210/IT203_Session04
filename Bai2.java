public class Bai2 {
    static void main(String[] args) {
        String description = " Sách giáo khoa Toán lớp 12, Kệ: A1-102, tình trạng mới";
        //Kiểm tra có chứa "Kệ:"
        if (description.contains("Kệ:")) {
            int start = description.indexOf("Kệ:") + "Kệ:".length(); //Xác định vị trí bắt đầu của mã kệ
            int commaIndex = description.indexOf(",", start); //Tìm dấu phẩy sau "Kệ:"

            String shelfCode;
            if (commaIndex != -1) {
                shelfCode = description.substring(start, commaIndex).trim(); //Cắt chuỗi để lấy mã kệ
            } else {
                shelfCode = description.substring(start).trim();
            }
            //Trích xuất mã vị trí đứng ngay sau từ "Kệ:" cho đến hết dòng hoặc đến dấu phẩy tiếp theo
            System.out.println("Mã vị trí kệ: " + shelfCode);

            String newDescription = description.replace("Kệ:", "Vị trí lưu trữ:");
            // In kết quả
            System.out.print("Mô tả mới:");
            System.out.println(newDescription);
        } else {
            System.out.println("Không tìm thấy thông tin kệ sách trong mô tả.");
        }
    }
}