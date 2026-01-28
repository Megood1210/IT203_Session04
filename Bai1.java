import java.util.Scanner;
public class Bai1 {
    //Phương thức viết hoa chữ cái đầu mỗi từ
    public static String capitalizeEachWord(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase()).append(" ");
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhập tên sách, tác giả và thể loại
        System.out.print("Nhập tên sách: ");
        String bookName = sc.nextLine();
        System.out.print("Nhập tác giả: ");
        String author = sc.nextLine();
        System.out.print("Nhập thể loại: ");
        String category = sc.nextLine();
        //Định dạng lại
        String formattedBookName = bookName.trim().replaceAll("\\s+", " ").toUpperCase();
        String formattedAuthor = capitalizeEachWord(author);
        //In kết quả
        System.out.println("["+ formattedBookName + "]" +" - Tác giả: " + formattedAuthor);
    }
}
