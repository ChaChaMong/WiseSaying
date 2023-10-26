package com.ll;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final WiseSayingModel model;
    private final WiseSayingView view;

    public WiseSayingController(WiseSayingModel model, WiseSayingView view) {
        this.model = model;
        this.view = view;
    }

    public void execute(Scanner scanner, String command) {
        Request rq = new Request(command);

        if (command.equals("등록")) {
            create(scanner);
        } else if (command.equals("목록")) {
            index();
        } else if (command.startsWith("삭제?id=")) {
            int id = rq.getParamAsInteger("id", 0);
            if (id == 0) {
                System.out.println("올바른 번호를 입력하세요.");
            } else {
                delete(id);
            }
        } else if (command.startsWith("수정?id=")) {
            int id = rq.getParamAsInteger("id", 0);
            if (id == 0) {
                System.out.println("올바른 번호를 입력하세요.");
            } else {
                update(scanner, id);
            }
        } else if (command.equals("빌드")) {
            build();
        } else {
            System.out.println("등록되지 않은 명령입니다.");
        }
    }

    public void index() {
        List<WiseSaying> wiseSayingList = model.getWiseSayingList();
        view.index(wiseSayingList);
    }

    public void create(Scanner scanner) {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        int cnt = 1;
        for (WiseSaying data : model.getWiseSayingList()) {
            if (data.getId() > cnt){
                break;
            } else {
                cnt++;
            }
        }

        model.addWiseSaying(cnt, content, author);
        write();

        System.out.println(cnt + "번 명언이 등록되었습니다.");
    }

    public void delete(int id) {
        boolean deleted = model.deleteWiseSaying(id);
        if (deleted) {
            write();
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    public void update(Scanner scanner, int id) {
        WiseSaying wiseSaying = null;
        for (WiseSaying data : model.getWiseSayingList()) {
            if (data.getId() == id) {
                wiseSaying = data;
                break;
            }
        }

        if (wiseSaying != null) {
            System.out.println("명언(기존) : " + wiseSaying.getContent());
            System.out.print("명언 : ");
            String content = scanner.nextLine();
            System.out.println("작가(기존) : " + wiseSaying.getAuthor());
            System.out.print("작가 : ");
            String author = scanner.nextLine();

            model.updateWiseSaying(id, content, author);
            write();
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    private final JsonFileIO<WiseSaying> jsonFileIO = new JsonFileIO<>();
    String jsonLiveFilePath = "src/main/resources/liveData.json"; // JSON 파일의 경로를 설정
    String jsonBuildFilePath = "src/main/resources/data.json"; // JSON 파일의 경로를 설정


    public void load() {
        model.setWiseSayingList(jsonFileIO.readFile(jsonLiveFilePath, WiseSaying.class));
    }

    public void write() {
        jsonFileIO.writeFile(model.getWiseSayingList(), jsonLiveFilePath);
    }

    public void build() {
        jsonFileIO.writeFile(model.getWiseSayingList(), jsonBuildFilePath);

        System.out.println("data.json 파일의 내용이 갱신되었습니다.");
    }
}
