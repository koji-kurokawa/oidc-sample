package com.example.oidcapi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OidcUserController {
    @GetMapping("/user")
    @ResponseBody
    public String getUser(@AuthenticationPrincipal OidcUser user) {
        final String userName = user == null ? "guest" : user.getFullName();
        return "Hello, " + userName;
    }

    @GetMapping("/login-status")
    public Boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }
}
