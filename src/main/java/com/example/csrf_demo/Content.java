package com.example.csrf_demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Content {
    private String content;
    private String userName;
}
