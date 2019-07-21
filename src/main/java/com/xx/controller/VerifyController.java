package com.xx.controller;

import com.xx.model.ResultModel;
import com.xx.service.CdkeyService;
import com.xx.service.UserService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("verify")
public class VerifyController {

    @Autowired
    CdkeyService cdkeyService;

    /**
     * 验证key是否有效
     * @param token
     * @param key
     * @return
     */
    @RequestMapping("/verifyKey")
    public ResultModel verifyKey(String token, String key) {

        Boolean isPass = cdkeyService.verifyKey(token, key);

        return ResultModel.SUCCESS(isPass);
    }
}
