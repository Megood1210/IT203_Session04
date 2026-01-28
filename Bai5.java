import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Bai5 {
    static void main(String[] args) {
        String[] logs = {"2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345", "2024-05-20 | User: NguyenVanB | Action: RETURN | BookID: BK54321", "2024-05-21 | User: NguyenVanA | Action: BORROW | BookID: BK99999"};
        //Tách Ngày – Người dùng – Hành động – Mã sách
        String regex = "(\\d{4}-\\d{2}-\\d{2}) \\| User: (\\w+) \\| Action: (BORROW|RETURN) \\| BookID: (\\w+)";
        Pattern pattern = Pattern.compile(regex);

        int borrowCount = 0;
        int returnCount = 0;

        for (String log : logs) {
            Matcher matcher = pattern.matcher(log);
            //Nếutrong chuỗi log có một đoạn con khớp với Regex
            if (matcher.find()) {
                String date = matcher.group(1); // Lấy ra ngày
                String user = matcher.group(2);
                String action = matcher.group(3);
                String bookId = matcher.group(4);

                System.out.println("Ngày: " + date);
                System.out.println("Người dùng: " + user);
                System.out.println("Hành động: " + action);
                System.out.println("Mã sách: " + bookId);
                System.out.println("--------------------");

                if (action.equals("BORROW")) {
                    borrowCount++;
                } else if (action.equals("RETURN")) {
                    returnCount++;
                }
            }
        }

        System.out.println("Tổng số lượt mượn (BORROW): " + borrowCount);
        System.out.println("Tổng số lượt trả (RETURN): " + returnCount);
    }
}