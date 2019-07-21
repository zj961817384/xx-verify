package com.xx.model;

import org.springframework.util.DigestUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String phone;
    private String password;
    private String name;

    private String token;

    /**
     * 这个地方传入的密码需要是加密之后的
     * @param phone
     * @param password
     * @return
     */
    public static User createUser(String phone, String password) {
        User user = new User();
        user.setPassword(password);
        user.setPhone(phone);
        user.setName(phone);
        user.refreshToken();
        return user;
    }

    /**
     * md5加密密码
     * @param orignPassword
     * @return
     */
    public static String encryptionPassword(String orignPassword) {

        return DigestUtils.md5DigestAsHex(orignPassword.getBytes());
    }

    /**
     * 刷新token
     * @return
     */
    public String refreshToken() {
        this.token = UUID.randomUUID().toString().replace("-", "");
        return this.token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
