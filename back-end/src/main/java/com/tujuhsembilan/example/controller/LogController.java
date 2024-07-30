package com.tujuhsembilan.example.controller;

import com.tujuhsembilan.example.dto.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);
    @PostMapping("/log")
    public String receiveLog(@RequestBody Log log) {
        logger.info("Received log: " + log);
        return "Log received";
    }
}