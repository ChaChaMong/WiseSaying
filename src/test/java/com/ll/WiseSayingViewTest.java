package com.ll;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WiseSayingViewTest {
    private WiseSayingView view;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        view = new WiseSayingView();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testIndex() {
        // 더미 데이터를 생성
        List<WiseSaying> wiseSayingList = new ArrayList<>();
        wiseSayingList.add(new WiseSaying(1, "명언1", "작가1"));
        wiseSayingList.add(new WiseSaying(2, "명언2", "작가2"));

        // index 메서드 호출
        view.index(wiseSayingList);

        // 기대한 출력 문자열 생성
        String expectedOutput = "번호 / 작가 / 명언\r\n";
        expectedOutput += "----------------------\r\n";
        expectedOutput += "1 / 작가1 / 명언1\r\n";
        expectedOutput += "2 / 작가2 / 명언2\r\n";

        // 출력된 문자열과 기대한 출력 문자열을 비교
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testIndexWithEmptyList() {
        // 빈 목록을 사용하여 index 메서드 호출
        view.index(new ArrayList<>());

        // 기대한 출력 문자열 생성
        String expectedOutput = "번호 / 작가 / 명언\r\n";
        expectedOutput += "----------------------\r\n";

        // 출력된 문자열과 기대한 출력 문자열을 비교
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testIndexWithNullList() {
        // null 목록을 사용하여 index 메서드 호출
        view.index(null);

        // 기대한 출력 문자열 생성
        String expectedOutput = "번호 / 작가 / 명언\r\n";
        expectedOutput += "----------------------\r\n";

        // 출력된 문자열과 기대한 출력 문자열을 비교
        assertEquals(expectedOutput, outContent.toString());
    }

    // 테스트 종료 후 표준 출력을 복원
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
