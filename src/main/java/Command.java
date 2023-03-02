import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Command {
    static List<WiseSaying> wiseSayingList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public boolean regist() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        try {
            wiseSayingList.add(new WiseSaying(saying, author));
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
