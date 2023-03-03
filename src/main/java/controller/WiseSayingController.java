package controller;

import entity.WiseSaying;
import service.WiseSayingService;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    static List<WiseSaying> wiseSayingList;
    private WiseSayingService wiseSayingService;
    Scanner sc = new Scanner(System.in);
    private long id = 1;

    public void downLoad(List<WiseSaying> wiseSayingList) {
        this.wiseSayingService = new WiseSayingService();
        this.wiseSayingList = wiseSayingList;
    }

    public List<WiseSaying> upLoad() {
        return wiseSayingList;
    }

    public void regist() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        System.out.println(wiseSayingService.regist(saying, author, id)
                + "번 명언이 등록되었습니다.");
        id++;
    }

    public void print() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        wiseSayingService.print();
    }

    public void delete(String command) {
        long deletedId = wiseSayingService.delete(command);

        if (deletedId == 0) {
            System.out.println("올바른 명령어를 입력해 주세요.");
        } else {
            System.out.println(deletedId + "번 명언이 삭제되었습니다.");
        }
    }



    public void modify(String command) {
        long modifyedId = wiseSayingService.modify(command);

        System.out.println(modifyedId + "번 명언이 수정되었습니다.");
    }

    public void build() {
        wiseSayingService.build();
    }
}