package com.xiong.pojo;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gonghui on 2017/11/23.
 */
public class XUser {
    /**
     * 记录账户的持有人姓名、联络方式、余额、有效期、密码、流通范围等。
     * 为了安全，该表还应该由账户、姓名、有效期和余额组成的检验串，防止有人恶意修改余额或账号。
     */

    private String userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String question;
    private String answer;
    private Integer role;
    private BigDecimal amount;
    private String imageUrl;
    private Date createTime;
    private Date updateTime;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Integer getRole() {
        return role;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
