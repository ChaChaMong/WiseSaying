package com.ll;

import java.util.Scanner;

public class WiseSayingApp {
    public static void main(String[] args) {
        WiseSayingModel model = new WiseSayingModel();
        WiseSayingView view = new WiseSayingView();
        WiseSayingController controller = new WiseSayingController(model, view);

        controller.load();

        Scanner scanner = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();
            if (command.equals("등록")) {
                controller.create(scanner);
            } else if (command.equals("목록")) {
                controller.index();
            } else if (command.startsWith("삭제?id=")) {
                Request rq = new Request(command);
                int id = rq.getParamAsInteger("id", 0);
                if (id == 0) {
                    System.out.println("올바른 번호를 입력하세요.");
                } else {
                    controller.delete(id);
                }
            } else if (command.startsWith("수정?id=")) {
                Request rq = new Request(command);
                int id = rq.getParamAsInteger("id", 0);
                if (id == 0) {
                    System.out.println("올바른 번호를 입력하세요.");
                } else {
                    controller.update(scanner, id);
                }
            } else if (command.equals("빌드")) {
                controller.build();
            } else if (command.equals("종료")) {
                break;
            } else {
                System.out.println("등록되지 않은 명령입니다.");
            }
        }

        scanner.close();
    }
}