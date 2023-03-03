package service;

import entity.WiseSaying;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingService {
    private Scanner sc = new Scanner(System.in);
    private List<WiseSaying> wiseSayingList;

    public WiseSayingService() {
        this.wiseSayingList = new ArrayList<>();
    }

    public long regist(String saying, String author, long id) {
        wiseSayingList.add(new WiseSaying(saying, author, id));

        return id;
    }

    public void print() {
        if (wiseSayingList.isEmpty()) {
            return;
        }

        for (int index = wiseSayingList.size() - 1; index >= 0; index--) {
            WiseSaying wiseSaying = wiseSayingList.get(index);
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getSaying());
        }
    }

    public long delete(String command) {
        command = command.replace("삭제", "");

        if (command.startsWith("?id=")) {
            command = command.replace("?id=", "");
            for (WiseSaying wiseSaying : wiseSayingList) {
                long id = Long.parseLong(command);
                if (wiseSaying.getId() == id) {
                    wiseSayingList.remove(wiseSaying);

                    return id;
                }
            }
        }

        return 0;
    }

    public long modify(String command) {
        command = command.replace("수정", "");

        if (command.startsWith("?id=")) {
            command = command.replace("?id=", "");
            long id = Long.parseLong(command);

            for (WiseSaying wiseSaying : wiseSayingList) {
                if (wiseSaying.getId() == id) {
                    System.out.println("명언(기존) : " + wiseSaying.getSaying());
                    System.out.print("명언 : ");
                    wiseSaying.setSaying(sc.nextLine());

                    System.out.println("작가(기존) : " + wiseSaying.getAuthor());
                    System.out.print("작가 : ");
                    wiseSaying.setAuthor(sc.nextLine());

                    return id;
                }
            }

            System.out.println(Integer.parseInt(command) + "번 명언은 존재하지 않습니다.");
        }

        System.out.println("올바른 수정 명령 형식을 지켜주세요.");
        return 0;
    }

    public void build() {
        String path = "C:\\Users\\sue\\java-project\\wise-saying\\data.json";

        JSONArray jsonArray = new JSONArray();
        for (WiseSaying wiseSaying : wiseSayingList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("saying", wiseSaying.getSaying());
            jsonObject.put("author", wiseSaying.getAuthor());
            jsonObject.put("id", wiseSaying.getId());
            jsonArray.add(jsonObject);
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(jsonArray.toString());
        } catch (Exception e) {
            System.out.println("빌드가 실패 했습니다.");
        }

        System.out.println("빌드가 완료 되었습니다.");
    }
}
