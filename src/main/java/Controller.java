import java.util.Scanner;

public class Controller {
    Command feat = new Command();
    Scanner sc = new Scanner(System.in);
    String command = "";

    public void run() {
        new WiseSayingFile().createFile();
        new Command().downLoad(new WiseSayingFile().readFile());

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
        }

        new WiseSayingFile().writeFile(new Command().upLoad());
    }
}
