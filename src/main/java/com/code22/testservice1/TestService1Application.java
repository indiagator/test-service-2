package com.code22.testservice1;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestService1Application {

    public static void main(String[] args) {
        SpringApplication.run(TestService1Application.class, args);
    }

    @GetMapping(value = "/test", produces = "application/json")
    public String getResponse() throws JsonProcessingException {
        Message testMsg = new Message();
        testMsg.setMsgString("Everything A.OK!");
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.writeValueAsString(testMsg);

    }

}
