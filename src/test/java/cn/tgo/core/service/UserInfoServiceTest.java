package cn.tgo.core.service;

import cn.tgo.core.bean.UserInfo;
import cn.tgo.core.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class UserInfoServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    static UserInfoService userInfoService;
    @Test
    public void addUserTest() throws Exception {
       UserInfo userInfo = new UserInfo();
       userInfo.setUserName("马克思");
       userInfo.setUserPw("WxH2aO");
       userInfoService.addUser(userInfo);
    }
    @Test
    public void getListTest() throws Exception {
        UserInfo userInfo = new UserInfo();
        //userInfo.setUserName("华");
        userInfo.setUserType("");
       List<UserInfo> list = userInfoService.getList(userInfo);
        for (UserInfo u : list) {
            System.out.println(u);
        }
    }
    public static void main(String[] args) throws Exception {
        UserInfo user = new UserInfo();
        user.setUserName("啊啊啊");
        user.setUserPw("asjklaj");
        ApplicationContext ctx= new ClassPathXmlApplicationContext("application-context.xml");
        userInfoService=ctx.getBean("userInfoService", UserInfoServiceImpl.class);
        userInfoService.addUser(user);
    }

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
}
