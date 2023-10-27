package com.ll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RqTest {
    @Test
    void testGetParameter() {
        Rq rq = new Rq("http://example.com/test?name=John&id=123");
        assertEquals("John", rq.getParameter("name"));
        assertEquals("123", rq.getParameter("id"));
        assertNull(rq.getParameter("age"));
    }

    @Test
    void testGetParameterAsInt() {
        Rq rq = new Rq("http://example.com/test?id=456");
        assertEquals(456, rq.getParameterAsInt("id", 0));
        assertEquals(0, rq.getParameterAsInt("age", 0));
        assertEquals(789, rq.getParameterAsInt("price", 789));
    }

    @Test
    void testGetParameterOrDefault() {
        Rq rq = new Rq("http://example.com/test?name=Alice");
        assertEquals("Alice", rq.getParameterOrDefault("name", "Unknown"));
        assertEquals("Unknown", rq.getParameterOrDefault("city", "Unknown"));
    }
}
