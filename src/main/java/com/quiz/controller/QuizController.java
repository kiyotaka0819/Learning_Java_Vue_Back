package com.quiz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class QuizController {

    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        // 文字列じゃなくてJSON形式（Map）で返す
        return Map.of("message", "SpringBootとVueの連携、完了");
    }
}
