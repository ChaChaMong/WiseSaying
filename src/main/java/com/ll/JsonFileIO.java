package com.ll;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonFileIO {

    String jsonFilePath = "src/main/resources/data.json"; // JSON 파일의 경로를 설정
    // Gson 객체 생성
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<WiseSaying> readFile() {
        List<WiseSaying> dataList = null;
        try (FileReader reader = new FileReader(jsonFilePath)) {
            // JSON 파일을 읽어서 List로 파싱
            Type listType = new TypeToken<List<WiseSaying>>() {}.getType();
            dataList = gson.fromJson(reader, listType); // List 타입으로 파싱

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public void writeFile(List<WiseSaying> dataList) {
        String jsonData = gson.toJson(dataList);

        try (FileWriter writer = new FileWriter(jsonFilePath)) {
            // JSON 문자열을 파일에 쓰기
            writer.write(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("data.json 파일의 내용이 갱신되었습니다.");
    }
}
