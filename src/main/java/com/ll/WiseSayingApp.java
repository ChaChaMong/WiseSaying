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

            if (command.equals("종료")) {
                break;
            }

            controller.execute(scanner, command);
        }

        scanner.close();
    }
}