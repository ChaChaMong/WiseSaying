package com.ll;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingModel {

    private List<WiseSaying> wiseSayingList;

    public WiseSayingModel() {
        this.wiseSayingList = new ArrayList<>();
    }

    public List<WiseSaying> getWiseSayingList() {
        return wiseSayingList;
    }

    public void setWiseSayingList(List<WiseSaying> data) {
        this.wiseSayingList = data;
    }

    public void addWiseSaying(int id, String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(id - 1, wiseSaying);
    }

    public boolean deleteWiseSaying(int id) {
        for (WiseSaying data : wiseSayingList) {
            if (data.getId() == id) {
                wiseSayingList.remove(data);
                return true;
            }
        }
        return false;
    }

    public void updateWiseSaying(int id, String newContent, String newAuthor) {
        for (WiseSaying data : wiseSayingList) {
            if (data.getId() == id) {
                data.setContent(newContent);
                data.setAuthor(newAuthor);
                break;
            }
        }
    }
}
