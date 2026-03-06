package com.kiyotaka.weatherapp.service;

import com.kiyotaka.weatherapp.dto.ScheduleRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class SlackService {

    private final String SLACK_WEBHOOK_URL = "";

    public void sendScheduleNotification(ScheduleRequest request) {
        String message = String.format(
            "📅 *【OS風アプリから予定登録】*\n・日時: %s\n・場所: %s\n・内容: %s\n・天気予報: %s\n・推奨服装: %s\n・傘の準備: %s",
            request.date(), request.location(), request.title(), 
            request.weather(), request.clothes(), request.umbrella()
        );

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            String json = "{\"text\": \"" + message + "\"}";

            restTemplate.postForEntity(SLACK_WEBHOOK_URL, new HttpEntity<>(json, headers), String.class);
        } catch (Exception e) {
            System.err.println("Slack通知に失敗しました: " + e.getMessage());
        }
    }
}