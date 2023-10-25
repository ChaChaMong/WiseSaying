package com.ll;

public class Request {
    private String command;
    private String[] parts;

    public Request(String command) {
        this.command = command;
        this.parts = command.split("[?]");
    }

    public String getCommand() {
        return command;
    }

    public String[] getParts() {
        return parts;
    }

    public String getParam(String paramName) {
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].startsWith(paramName + "=")) {
                return parts[i].substring(paramName.length() + 1);
            }
        }
        return null;
    }

    public int getParamAsInteger(String paramName, int defaultValue) {
        String param = getParam(paramName);
        if (param != null) {
            try {
                return Integer.parseInt(param);
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }
}
