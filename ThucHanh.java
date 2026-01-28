import java.util.Scanner;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ThucHanh {
    //Phần 2
    public static String normalizeText(String input) {
        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(
                    Character.toUpperCase(word.charAt(0))
            ).append(
                    word.substring(1).toLowerCase()
            ).append(" ");
        }
        return result.toString().trim();
    }
    //Phần 3
    public static String buildCitation(String bookId, String title,
                                       String author, int year) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bookId).append("] - ").append(title).append(" - ").append(author).append(" (").append(year).append(")");return sb.toString();}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String bookId;
        String isbn;
        String rawTitle;
        String rawAuthor;
        String publishYearStr;
        int publishYear = 0;
        //Nhập và kiểm tra mã sách
        Pattern bookIdPattern = Pattern.compile("LIB-[0-9]{4}-S");
        Matcher matcher;
        do {
            System.out.print("Nhập mã sách (LIB-xxxx-S): ");
            bookId = sc.nextLine().trim();
            matcher = bookIdPattern.matcher(bookId);
            if (!matcher.matches()) {
                System.out.println("Mã sách không hợp lệ");
            }
        } while (!matcher.matches());
        //Nhập và kiểm tra ISBN
        Pattern isbnPattern = Pattern.compile("[0-9]{10}");
        do {
            System.out.print("Nhập ISBN (10 chữ số): ");
            isbn = sc.nextLine().trim();
            matcher = isbnPattern.matcher(isbn);
            if (!matcher.matches()) {
                System.out.println("ISBN không hợp lệ");
            }
        } while (!matcher.matches());
        //Nhập và kiểm tra năm xuất bản
        Pattern yearPattern = Pattern.compile("[0-9]{4}");
        int currentYear = new Date().getYear() + 1900;
        do {
            System.out.print("Nhập năm xuất bản: ");
            publishYearStr = sc.nextLine().trim();

            matcher = yearPattern.matcher(publishYearStr);

            if (!matcher.matches()) {
                System.out.println("Năm xuất bản phải gồm 4 chữ số");
                continue;
            }
            publishYear = Integer.parseInt(publishYearStr);

            if (publishYear > currentYear) {
                System.out.println("Năm xuất bản không được lớn hơn năm hiện tại (" + currentYear + ")");
            }
        } while (!matcher.matches() || publishYear > currentYear);

        //Phần 2
        System.out.print("Nhập tên sách: ");
        rawTitle = sc.nextLine();

        System.out.print("Nhập tên tác giả: ");
        rawAuthor = sc.nextLine();

        String title = normalizeText(rawTitle);
        String author = normalizeText(rawAuthor);

        System.out.println("---- KẾT QUẢ BIÊN MỤC ----");
        System.out.println("Mã sách chuẩn: " + bookId);
        System.out.println("ISBN-10: " + isbn);
        System.out.println("Tên sách: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm XB: " + publishYear);
        System.out.println("Trích dẫn: " + buildCitation(bookId, title, author, publishYear));
        System.out.println("--------------------------");
    }
}