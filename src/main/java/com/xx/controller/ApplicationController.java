package com.xx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ApplicationController {

    @RequestMapping("checkpreload.htm")
    public String checkpreload() {
        return "SUCCESS";
    }

    @RequestMapping("generatekey")
    public String generateKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
