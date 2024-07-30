package com.tujuhsembilan.example.dto;

import lombok.Data;

@Data
public class Log {
    private String message;
    private String stack;
    private Object info;
    private String timestamp;

    @Override
    public String toString() {
        return "Log{" +
                "message='" + message + '\'' +
                ", stack='" + stack + '\'' +
                ", info=" + info +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}