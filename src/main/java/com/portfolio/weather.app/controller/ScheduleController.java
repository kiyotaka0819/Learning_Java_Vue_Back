package com.kiyotaka.weatherapp.controller;

import com.portfolio.weather.app.dto.ScheduleRequest;
import com.portfolio.weather.app.service.SlackService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Vue（StackBlitzなど）からのアクセスを許可
public class ScheduleController {

    private final SlackService slackService;

    // コンストラクタ
    public ScheduleController(SlackService slackService) {
        this.slackService = slackService;
    }

    @PostMapping("/schedule")
    public Map<String, String> register(@RequestBody ScheduleRequest request) {
        // Serviceに通知処理を投げる
        slackService.sendScheduleNotification(request);

        return Map.of(
            "status", "success",
            "message", request.date() + "の予定をSlackに飛ばしました"
        );
    }
}