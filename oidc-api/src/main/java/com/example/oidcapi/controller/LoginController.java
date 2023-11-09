package com.example.oidcapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @Value("${Client.postLoginUrl}")
    private String POST_LOGIN_CLIENT_URL;

    @GetMapping("/cg-login")
    public String cgLogin(@AuthenticationPrincipal OidcUser user) {
        System.out.printf("====== Logged in user: %s (%s)   %s\n", user.getName(), user.getEmail(), user);
        return "redirect:" + POST_LOGIN_CLIENT_URL;
    }
}
