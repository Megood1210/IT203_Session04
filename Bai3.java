import java.text.SimpleDateFormat;
import java.util.Date;
public class Bai3 {
    public static void main(String[] args) {
        // Danh sách giao dịch giả lập
        String[] transactions = {"BK001-20/01","BK005-21/01","BK099-22/01"};
        // Lấy ngày hiện tại
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(new Date()); //.format() định dạng đối tượng ngày (LocalDate) thành chuỗi

        long startSB = System.currentTimeMillis(); //lấy thời điểm hiện tại của hệ thống tính bằng mili-giây

        StringBuilder reportSB = new StringBuilder();
        reportSB.append("--- BÁO CÁO MƯỢN SÁCH ---\n");
        reportSB.append("Ngày tạo: ").append(today).append("\n");

        for (String t : transactions) {
            reportSB.append("Giao dịch: ").append(t).append("\n");
        }

        long endSB = System.currentTimeMillis();

        long startString = System.currentTimeMillis();

        String reportStr = "";
        reportStr += "--- BÁO CÁO MƯỢN SÁCH ---\n";
        reportStr += "Ngày tạo: " + today + "\n";

        for (String t : transactions) {
            reportStr += "Giao dịch: " + t + "\n";
        }

        long endString = System.currentTimeMillis();
        //In kết quả
        System.out.println(reportSB.toString());
        System.out.println("Số thời gian thực thi đối với StringBuilder: " + (endSB - startSB));
        System.out.println("Số thời gian thực thi đối với String: " + (endString - startString));
    }
}
