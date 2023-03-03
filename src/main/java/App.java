import controller.WiseSayingController;

import java.util.Scanner;

public class App {
    WiseSayingController feat = new WiseSayingController();
    Scanner sc = new Scanner(System.in);
    String command = "";

    public void run() {
        new WiseSayingFile().createFile();
        new WiseSayingController().downLoad(new WiseSayingFile().readFile());

        System.out.println("== 명언 앱 ==");

        while (!command.equals("종료")) {
            System.out.print("명령) ");
            command = sc.nextLine().trim();

            if (command.equals("등록")) {
                feat.regist();
            }
            else if (command.equals("목록")) {
                feat.print();
            }
            else if (command.startsWith("삭제")) {
                feat.delete(command);
            }
            else if (command.startsWith("수정")) {
                feat.modify(command);
            }
            else if (command.equals("빌드")) {
                feat.build();
            }
        }

        new WiseSayingFile().writeFile(new WiseSayingController().upLoad());
    }
}
