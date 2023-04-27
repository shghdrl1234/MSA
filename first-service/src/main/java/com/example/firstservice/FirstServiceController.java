package com.example.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class FirstServiceController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the First service.";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info(header);
        return  "<h1>나는 첫번째 서비스다~</h1>";
    }

    @GetMapping("/check")
    public String check() {
        return "1번 서비스 확인.";
    }
}
