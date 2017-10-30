package cn.tgo.core.service.impl;

import cn.tgo.core.bean.UserInfo;
import cn.tgo.core.dao.UserInfoDao;
import cn.tgo.core.service.UserInfoService;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoDao userInfoDao;
    public void addUser(UserInfo userInfo) {
        System.out.println("插入"+userInfoDao.add(userInfo)+"条记录");
        //throw new RuntimeException("运行时异常");
    }

    public void updateUser(UserInfo userInfo) {
        if(userInfoDao.update(userInfo)>0){
            System.out.println("更新用户成功！");
        }else{
            System.out.println("更新用户失败！");
        }
    }

    public void deleteUser(UserInfo userInfo) {
        if(userInfoDao.delete(userInfo)>0){
            System.out.println("删除用户成功！");
        }else{
            System.out.println("删除用户失败！");
        }
    }

    public List<UserInfo> getList(UserInfo userInfo) {
        if(userInfo.getUserName()!=null && !userInfo.getUserName().equals("")){
            userInfo.setUserName("%"+userInfo.getUserName()+"%");
        }
        return userInfoDao.getUserList(userInfo);
    }

    public Long getCount(UserInfo userInfo) {
        return userInfoDao.getCount(userInfo);
    }

    public UserInfo getUserInfo(UserInfo user) {
        return  userInfoDao.getUserInfo(user);
    }

    public void uploadExcel(InputStream in) throws Exception {
        // 选取Excel文件得到工作薄Workbook
        Workbook book = Workbook.getWorkbook(in);
        // 通过Workbook的getSheet方法选择第一个工作表（从0开始）
        Sheet sheet = book.getSheet(0);
        System.out.println(sheet.getColumns());
        System.out.println(sheet.getRows());
        for (int i = 1; i < sheet.getRows(); i++) {

            UserInfo user = new UserInfo();

            // 姓名
            Cell namecell = sheet.getCell(0, i);
            String userName = namecell.getContents();
            user.setUserName(userName);

            // 性别
            Cell sexcell = sheet.getCell(1, i);
            String userSex = sexcell.getContents();
            user.setUserSex(userSex);

            // 电话号码
            Cell phonecell = sheet.getCell(2, i);
            String userPhone = phonecell.getContents();
            user.setUserPhone(userPhone);

            // 密码
            Cell pwcell = sheet.getCell(3, i);
            String userPw = pwcell.getContents();
            user.setUserPw(userPw);

            // 用户类型
            Cell typecell = sheet.getCell(4, i);
            String userType = typecell.getContents();
            user.setUserType(userType);

            userInfoDao.add(user);

        }
        book.close();

    }
    @Autowired
    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }
}
