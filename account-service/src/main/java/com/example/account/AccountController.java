package com.example.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/internal/accounts")
public class AccountController {

    @GetMapping("/{id}")
    public String getAccount(@PathVariable String id) {
        return "Account details for account ID: " + id;
    }
}
