package cn.tgo.core.dao;

import cn.tgo.core.bean.UserInfo;

import java.util.List;

public interface UserInfoDao {
    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    public int add(UserInfo userInfo);

    /**
     * 更新用户
     * @param userInfo
     * @return
     */
    public int update(UserInfo userInfo);

    /**
     * 删除用户
     * @param userInfo
     * @return
     */
    public int delete(UserInfo userInfo);

    /**
     * 根据条件查询
     * @param userInfo
     * @return
     */
    public List<UserInfo> getUserList(UserInfo userInfo);

    /**
     * 查询总记录数
     * @param userInfo
     * @return
     */
    public long getCount(UserInfo userInfo);

    /**
     * 根据条件查询用户
     * @param user
     * @return
     */
    UserInfo getUserInfo(UserInfo user);
}
