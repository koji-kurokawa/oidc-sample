package com.example.oidcapi.controller;

import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// CloudGearのWebHook仕様:
// https://cloudgear-docs.atlassian.net/wiki/spaces/CG/pages/1310765/WebHook

@RestController
@RequiredArgsConstructor
@RequestMapping("/webhook")
public class WebHookController {
    public ResponseEntity<String> receive(@RequestBody WebHookRequest request, ServletRequest servletRequest) {
        // WebHookの署名検証
        // WebHookの内容をチェックして、必要に応じてService経由でDBなどを操作する
        return ResponseEntity.ok("OK");
    }

    @Value
    static class WebHookRequest {
        String id;
        String event;
        String type;
        JSONObject data;
        String createdAt;
        Integer version;
    }
}
