package com.xx.service;

import com.xx.dao.UserDAO;
import com.xx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public String login(String phone, String password) {
        User user = userDAO.findByPhone(phone);
        String p = password == null ? "" : password;
        //没有该用户就新建一个记录
        if (user == null) {
            user = User.createUser(phone, User.encryptionPassword(p));
        }
        //验证是否密码相同
        if (User.encryptionPassword(p).equals(user.getPassword())) {
            user.refreshToken();
            userDAO.save(user);
            return user.getToken();
        }
        return null;
    }

    public Boolean verifyLogin(String phone, String token) {
        User user = userDAO.findByToken(token);
        if (user == null || !user.getPhone().equals(phone)) {
            return false;
        }
        return true;
    }
}
