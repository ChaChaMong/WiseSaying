package com.ll;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WiseSaying {

    static private int lastId = 0;

    public void create(Scanner scanner, List<Data> wiseSayingList) {

        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        lastId++;
        Data data = new Data(lastId, content, author);

        wiseSayingList.add(0, data);
        System.out.println(data.getId() + "번 명언이 등록되었습니다.");
    }

    public void index(List<Data> wiseSayingList) {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (Data data : wiseSayingList) {
            System.out.println(data.getId() + " / " + data.getAuthor() + " / " + data.getContent());
        }
    }

    public void delete(List<Data> wiseSayingList, int id) {
        boolean deleted = false;
        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == id) {
                wiseSayingList.remove(i);
                deleted = true;
                System.out.println(id + "번 명언이 삭제되었습니다.");
                break;
            }
        }
        if (!deleted) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    public void edit(Scanner scanner, List<Data> wiseSayingList, int id) {
        boolean edited = false;
        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == id) {
                //wiseSayingList.remove(i);
                System.out.println("명언(기존) : " + wiseSayingList.get(i).getContent());
                System.out.print("명언 : ");
                String content = scanner.nextLine();
                System.out.println("작가(기존) : " + wiseSayingList.get(i).getAuthor());
                System.out.print("작가 : ");
                String author = scanner.nextLine();

                wiseSayingList.get(i).setContent(content);
                wiseSayingList.get(i).setAuthor(author);

                edited = true;
                break;
            }
        }
        if (!edited) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    public void build(HashMap<Integer, Data> wiseSayingList) {

    }
}
