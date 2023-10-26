package com.ll.test;

import com.ll.WiseSaying;
import com.ll.WiseSayingModel;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class WiseSayingModelTest {
    @Test
    void testAddWiseSaying() {
        WiseSayingModel model = new WiseSayingModel();
        model.addWiseSaying(1, "작가1TEST", "명언1TEST");
        List<WiseSaying> WiseSayings = model.getWiseSayingList();
        assertEquals(1, WiseSayings.size());
    }

    @Test
    void testDeleteWiseSaying() {
        WiseSayingModel model = new WiseSayingModel();
        model.addWiseSaying(1, "작가1TEST", "명언1TEST");
        model.addWiseSaying(2, "작가2TEST", "명언2TEST");
        boolean result = model.deleteWiseSaying(1);
        assertTrue(result);
        List<WiseSaying> WiseSayings = model.getWiseSayingList();
        assertEquals(1, WiseSayings.size());

        // 삭제된 명언(ID 1)이 목록에 없어야 함
        for (WiseSaying wiseSaying : WiseSayings) {
            assertNotEquals(1, wiseSaying.getId());
        }
    }

    @Test
    void testUpdateWiseSaying() {
        WiseSayingModel model = new WiseSayingModel();
        model.addWiseSaying(1, "작가1TEST", "명언1TEST");
        model.updateWiseSaying(1, "새작가TEST", "새명언TEST");
        List<WiseSaying> WiseSayings = model.getWiseSayingList();
        assertEquals("새작가TEST", WiseSayings.get(0).getContent());
        assertEquals("새명언TEST", WiseSayings.get(0).getAuthor());
    }
}
