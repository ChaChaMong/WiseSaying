package com.ll;

import com.ll.standard.util.Ut;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private final Map<String, String> paramsMap;

    public Rq(String url) {
        this.paramsMap = new HashMap<>();
        if (url != null) {
            String[] parts = url.split("\\?");
            if (parts.length > 1) {
                String[] paramPairs = parts[1].split("&");
                for (String paramPair : paramPairs) {
                    String[] keyValue = paramPair.split("=");
                    if (keyValue.length == 2) {
                        paramsMap.put(keyValue[0], keyValue[1]);
                    }
                }
            }
        }
    }

    public String getParameter(String paramName) {
        return paramsMap.get(paramName);
    }

    public int getParameterAsInt(String paramName, int defaultValue) {
        return Ut.str.parseInt(paramsMap.get(paramName), defaultValue);
    }

    public String getParameterOrDefault(String paramName, String defaultValue) {
        String value = paramsMap.get(paramName);
        return value != null ? value : defaultValue;
    }
}