import java.util.List;
import java.util.Scanner;

public class Command {
    static List<WiseSaying> wiseSayingList;
    Scanner sc = new Scanner(System.in);
    int id = 1;

    public void downLoad(List<WiseSaying> wiseSayingList) {
        this.wiseSayingList = wiseSayingList;
    }

    public List<WiseSaying> upLoad() {
        return wiseSayingList;
    }

    public boolean regist() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        try {
            wiseSayingList.add(new WiseSaying(saying, author, id));
            System.out.println(id++ + "번 명언이 등록되었습니다.");
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public void print() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        if (wiseSayingList.isEmpty()) {
            System.out.println("비어있어?");
            return;
        }

        for (int index = wiseSayingList.size() - 1; index >= 0; index--) {
            WiseSaying wiseSaying = wiseSayingList.get(index);
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getSaying());
        }
    }

    public boolean delete(String command) {
        command = command.replace("삭제", "");

        if (command.startsWith("?id=")) {
            command = command.replace("?id=", "");

            for (WiseSaying wiseSaying : wiseSayingList) {
                if (wiseSaying.getId() == (Integer.parseInt(command))) {
                    wiseSayingList.remove(wiseSaying);
                    System.out.println((Integer.parseInt(command)) + "번 명령이 삭제되었습니다.");
                    return true;
                }
            }

            System.out.println(Integer.parseInt(command) + "번 명언은 존재하지 않습니다.") ;
        }
        else {
            System.out.println("올바른 삭제 명령 형식을 지켜주세요.");
            return false;
        }

        return true;
    }

    public boolean modify(String command) {
        command = command.replace("수정", "");

        if (command.startsWith("?id=")) {
            command = command.replace("?id=", "");

            for (WiseSaying wiseSaying : wiseSayingList) {
                if (wiseSaying.getId() == (Integer.parseInt(command))) {
                    System.out.println("명언(기존) : " + wiseSaying.getSaying());
                    System.out.print("명언 : ");
                    wiseSaying.setSaying(sc.nextLine());

                    System.out.println("작가(기존) : " + wiseSaying.getAuthor());
                    System.out.print("작가 : ");
                    wiseSaying.setAuthor(sc.nextLine());

                    return true;
                }
            }

            System.out.println(Integer.parseInt(command) + "번 명언은 존재하지 않습니다.");
        }
        else {
            System.out.println("올바른 수정 명령 형식을 지켜주세요.");
            return false;
        }

        return true;
    }
}
