package com.example.firstservice;

import com.netflix.discovery.converters.Auto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class FirstServiceController {

    Environment env;
    
    @Autowired // 생성자 통해서 주입
    public FirstServiceController(Environment env) {
        this.env = env;
    }

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
    public String check(HttpServletRequest request) {
        log.info("서버 포트 = {}", request.getServerPort());

        return String.format("1번 서비스 확인.", env .getProperty("local.server port"));
    }

}
