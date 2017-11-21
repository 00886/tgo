package cn.tgo.core.service;

import cn.tgo.core.bean.GoodsInfo;
import cn.tgo.core.bean.UserInfo;
import cn.tgo.core.service.impl.UserInfoServiceImpl;
import cn.tgo.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class GoodsInfoServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    static GoodsInfoService goodsInfoService;
    @Test
    public void addGoodsTest() throws Exception {
       GoodsInfo goodsInfo = new GoodsInfo();
       goodsInfo.setGoodsName("I7主机");
       goodsInfo.setGoodsPrice(700.00);
       goodsInfo.setGoodsDesc("吃鸡无压力");
       goodsInfo.setGoodsUrl(Common.IMG_SERVER_URL+"upload/201711211634251087.jpg");
       goodsInfo.setGoodsState("1");
       goodsInfoService.addGoods(goodsInfo);
    }
  /*  @Test
    public void queryUserByCriteria() throws Exception {
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
    }*/

    @Autowired
    public void setGoodsInfoService(GoodsInfoService goodsInfoService) {
        this.goodsInfoService = goodsInfoService;
    }
}
