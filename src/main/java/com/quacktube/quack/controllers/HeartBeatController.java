package com.quacktube.quack.controllers;

import com.quacktube.quack.constants.EndpointConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeatController {

    private static final Logger logger = LoggerFactory.getLogger(HeartBeatController.class);

    @GetMapping(EndpointConstants.HEARTBEAT)
    public ResponseEntity<String> heartbeat() {
        logger.info("Server is Live / Heartbeat Protocol");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
