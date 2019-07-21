package com.xx.controller;

import com.xx.model.ResultModel;
import com.xx.service.UserService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/t")
    public ResultModel test(String s) {
        return ResultModel.SUCCESS("Application String：" + s);
    }

    /**
     * 登录，不存在则用用户名密码创建用户
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public ResultModel login(@RequestParam(required = true) String phone,
                             @RequestParam String password) {

        String token = userService.login(phone, password);

        return ResultModel.SUCCESS(token);
    }

    /**
     * 验证这个token是否是有效token
     * @param phone
     * @param token
     * @return
     */
    @RequestMapping("/verifyLogin")
    public ResultModel verifyLogin(String phone, String token) {
        Boolean isPass = userService.verifyLogin(phone, token);
        return ResultModel.SUCCESS(isPass);
    }
}
