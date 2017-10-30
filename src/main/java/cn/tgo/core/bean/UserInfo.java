package cn.tgo.core.bean;

import cn.tgo.util.BaseBean;

public class UserInfo extends BaseBean {
    private Integer userId;
    private String userName;
    private String userSex;
    private String userPhone;
    private String userPw;
    private String userType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserInfo:[userId="+userId+",userName="+userName+",userSex="+userSex+",userPhone="+userPhone+",userPw="+userPw+",userType="+userType+"]";
    }
}
