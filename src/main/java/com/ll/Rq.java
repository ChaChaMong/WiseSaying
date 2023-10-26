package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private final Map<String, String> params;

    public Rq(String url) {
        this.params = new HashMap<>();
        if (url != null) {
            String[] parts = url.split("\\?");
            if (parts.length > 1) {
                String[] paramPairs = parts[1].split("&");
                for (String paramPair : paramPairs) {
                    String[] keyValue = paramPair.split("=");
                    if (keyValue.length == 2) {
                        params.put(keyValue[0], keyValue[1]);
                    }
                }
            }
        }
    }

    public String getParameter(String paramName) {
        return params.get(paramName);
    }

    public int getParameterAsInt(String paramName, int defaultValue) {
        String value = params.get(paramName);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                // 파싱 실패 시, defaultValue 반환
            }
        }
        return defaultValue;
    }

    public String getParameterOrDefault(String paramName, String defaultValue) {
        String value = params.get(paramName);
        return value != null ? value : defaultValue;
    }
}