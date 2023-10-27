package com.ll;

import java.util.List;

public class WiseSayingView {
    public void index(List<WiseSaying> wiseSayingList) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        if (wiseSayingList != null) {
            for (WiseSaying data : wiseSayingList) {
                System.out.printf("%d / %s / %s%n", data.getId(), data.getAuthor(), data.getContent());
            }
        }
    }
}
