import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Bai6 {
    public static void main(String[] args) {
        String review = "Cuốn sách này rất tệ, nội dung thật là ngu ngốc và không đáng đọc.";
        String[] blacklist = {"tệ", "ngu ngốc"};

        String cleanReview = review;
        //Thay thế từ nhạy cảm bằng **** theo độ dài
        for (String badWord : blacklist) {
            String regex = "(?i)" + badWord; // (?i) không phân biệt hoa thường
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cleanReview);

            while (matcher.find()) {
                String stars = "*".repeat(matcher.group().length()); //Tự động tạo số dấu * đúng bằng độ dài từ xấu
                cleanReview = cleanReview.replaceAll(regex, stars);
            }
        }
        //Cắt ngắn nếu quá 200 ký tự (không cắt giữa từ)
        int MAX_LENGTH = 200;
        if (cleanReview.length() > MAX_LENGTH) {
            int cutIndex = cleanReview.lastIndexOf(" ", MAX_LENGTH); //Đảm bảo không cắt giữa một từ

            if (cutIndex == -1) {
                cutIndex = MAX_LENGTH;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(cleanReview.substring(0, cutIndex)); //Cắt chuỗi từ vị trí 0 đến trước cutIndex
            sb.append("...");

            cleanReview = sb.toString();//Chuyển StringBuilder thành String để nối chuỗi
        }
        //In kết quả
        System.out.println("Review sau khi xử lý: " + cleanReview);
    }
}