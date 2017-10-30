package cn.tgo.core.controller;

import cn.tgo.core.bean.UserInfo;
import cn.tgo.core.service.UserInfoService;
import cn.tgo.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserInfoController extends BaseController {

    private UserInfoService userInfoService;

    /**
     * 加载添加用户页面
     * @param userInfo
     * @return
     */
    @RequestMapping("user/loadadd.do")
    public String loadAdd(UserInfo userInfo){
        System.out.println(userInfo);
        return "userinfo/userinfo_add";
    }

    @RequestMapping("user/loadupdate.do")
    public String loadUpdate(UserInfo userInfo,Model model){
        UserInfo user = userInfoService.getUserInfo(userInfo);
        System.out.println("loadUpdate(): " + user);
        model.addAttribute("user",user);
        return "userinfo/userinfo_update";
    }

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @RequestMapping("user/add.do")
    public String add(UserInfo userInfo,Model model){
        String info = "操作失败！";
        try {
            userInfoService.addUser(userInfo);
            info = "操作成功！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("info",info);
        return "userinfo/userinfo_info";
    }

    @RequestMapping("user/update.do")
    public String update(UserInfo userInfo,Model model){

        String info = "操作失败！";
        try {
            userInfoService.updateUser(userInfo);
            info = "操作成功！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("info",info);
        return "userinfo/userinfo_info";
    }

    @RequestMapping("user/delete.do")
    public String delete(UserInfo userInfo,Model model){

        String info = "操作失败！";
        try {
            userInfoService.deleteUser(userInfo);
            info = "操作成功！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("info",info);
        return "userinfo/userinfo_info";
    }


    /**
     *
     * @param userInfo
     * @return
     */
    @RequestMapping("back/login.do")
    public String login(UserInfo userInfo){
        return "main/index";
    }

    @RequestMapping("back/bootm.do")
    public String bootm(){
        return "main/bootm";
    }

    /**
     * 查询用户信息
     * @param model
     * @param userInfo
     * @param request
     * @return
     */
    @RequestMapping("user/list.do")
    public String list(Model model, UserInfo userInfo, HttpServletRequest request){
        if(userInfo != null){
            initPage(request);
            //设置起始记录数
            userInfo.setStart(this.getPageNo());
            //每页显示记录数
            userInfo.setLength(getPageNumBig());
        }
        List<UserInfo> list = userInfoService.getList(userInfo);

        model.addAttribute("list",list);
        //总记录数
        model.addAttribute("total", userInfoService.getCount(userInfo));
        return "userinfo/userinfo_list";
    }
    /**
     * 手机号码验证
     * @param user
     * @return
     */
   @RequestMapping(value = "user/userajax.do",produces="text/html;charset=UTF-8")//produces="text/html;charset=UTF-8"解决返回请求数据乱码的问题
   public @ResponseBody String userAjax(UserInfo user){
        UserInfo puser = userInfoService.getUserInfo(user);
       System.out.println(puser);
        if(puser!=null){
            return "手机号码已经存在，请重新输入";
            //return "{\"msg\":\"啦啦啦\"}";
        }else{
            return "恭喜您，手机号码可以使用!";
            //return "{\"msg\":\"哈哈哈\"}";
        }


    }

    /**
     * Excel导入数据到数据库
     * @return
     */
    @RequestMapping("user/imuser.do")
    public String uploadExcel(@RequestParam(value = "upfile", required = false) MultipartFile file,Model model){
        String info ="操作失败";
        try {
            System.out.println(file);
            userInfoService.uploadExcel(file.getInputStream());
            info = "操作成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("info", info);

        return "userinfo/userinfo_info";

    }

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
}
