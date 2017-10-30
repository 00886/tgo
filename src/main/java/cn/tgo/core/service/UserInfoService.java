package cn.tgo.core.service;

import cn.tgo.core.bean.UserInfo;

import java.io.InputStream;
import java.util.List;

public interface UserInfoService {
    /**
     * 添加用户
     * @param userInfo
     */
    void addUser(UserInfo userInfo);

    /**
     * 更新用户
     * @param userInfo
     */
    void updateUser(UserInfo userInfo);

    /**
     * 删除用户
     * @param userInfo
     */
    void deleteUser(UserInfo userInfo);

    /**
     * 根据条件查询用户
     * @param userInfo
     * @return
     */
    List<UserInfo> getList(UserInfo userInfo);

    Long getCount(UserInfo userInfo);

    UserInfo getUserInfo(UserInfo user);

    void uploadExcel(InputStream in) throws Exception;
}
