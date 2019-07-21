package com.xx.service;

import com.xx.dao.CdkeyDAO;
import com.xx.dao.UserDAO;
import com.xx.model.Cdkey;
import com.xx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CdkeyService {

    @Autowired
    CdkeyDAO cdkeyDAO;

    @Autowired
    UserDAO userDAO;

    public Boolean verifyKey(String token, String keyString) {
        User user = userDAO.findByToken(token);
        if (user == null) {
            return false;
        }
        Cdkey key = cdkeyDAO.findByUserId(user.getId());
        if(key == null) {
            return false;
        }
        if (key.getKey().equals(keyString)) {
            long current = System.currentTimeMillis();
            long begin = key.getBeginTime().getTime();
            long end = key.getEndTime().getTime();
            //判断key是否在生效时间内
            if (current >= begin && current <= end) {
                return true;
            }
        }
        return false;
    }
}
