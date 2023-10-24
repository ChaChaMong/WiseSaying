package com.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WiseSaying wiseSaying = new WiseSaying();
        List<Data> wiseSayingList = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();
            if (command.equals("등록")) {
                wiseSaying.create(scanner, wiseSayingList);
            } else if (command.equals("목록")) {
                wiseSaying.index(wiseSayingList);
            } else if (command.startsWith("삭제?id=")) {
                try {
                    String[] parts = command.split("=");
                    if (parts.length == 2) {
                        int id = Integer.parseInt(parts[1]);
                        wiseSaying.delete(wiseSayingList, id);
                    } else {
                        System.out.println("올바른 번호를 입력하세요.");
                    }
                } catch (Exception e) {
                    System.out.println("올바른 번호를 입력하세요.");
                }
            } else if (command.startsWith("수정?id=")) {
                try {
                    String[] parts = command.split("=");
                    if (parts.length == 2) {
                        int id = Integer.parseInt(parts[1]);
                        wiseSaying.edit(scanner, wiseSayingList, id);
                    } else {
                        System.out.println("올바른 번호를 입력하세요.");
                    }
                } catch (Exception e) {
                    System.out.println("올바른 번호를 입력하세요.");
                }
            } else if (command.equals("종료")) {
                break;
            } else {
                System.out.println("등록되지 않은 명령입니다.");
            }
        }

        scanner.close();
    }

}