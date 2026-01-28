import java.util.Scanner;
import java.util.regex.Pattern;
public class Bai4 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thẻ: ");
        String card = sc.nextLine().trim();
        if (!card.matches("^[A-Z]{2}.*")) {
            System.out.println("Thiếu tiền tố TV");
        }
        else if (!card.matches("^[A-Z]{2}[0-9]{4}.*")) {
            System.out.println("Năm không hợp lệ");
        }
        else if (!card.matches("^[A-Z]{2}[0-9]{4}[0-9]{5}$")) {
            System.out.println("Kết thúc phải là 5 chữ số");
        }
        else {
            System.out.println("Mã thẻ hợp lệ!");
        }
    }
}