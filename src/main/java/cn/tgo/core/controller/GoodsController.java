package cn.tgo.core.controller;

import cn.tgo.core.bean.GoodsInfo;
import cn.tgo.core.bean.ImgUrl;
import cn.tgo.core.service.GoodsInfoService;
import cn.tgo.util.Common;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 商品管理的控制器
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {


    private GoodsInfoService goodsInfoService;

    @RequestMapping("/loadadd.do")
    public String loadadd(){
        return "goodsinfo/goodsinfo_add";
    }

    /**
     * 上传商品图片
     * @param shopimg
     * @return
     */
    @RequestMapping("/upload.do")
    public @ResponseBody ImgUrl uploadImg(@RequestParam(required = false)MultipartFile shopimg){
        /*try {
            System.out.println(shopimg.getInputStream()+"------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImgUrl iu = new ImgUrl();
        iu.setPath("01.jpg");
        iu.setUrl("http://localhost:0000");*/
        try {
            //图片名称生产策略
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String format = df.format(new Date());
            Random random = new Random();
            format += random.nextInt(10000);
            System.out.println(format);

            //保存数据库路径
            String path = "upload/" + format + ".jpg";
            //另外一台服务器地址
            String url = Common.IMG_SERVER_URL + path;
            Client c = new Client();
            WebResource resource = c.resource(url);
            resource.put(String.class,shopimg.getBytes());
            System.out.println("发送成功！");
            ImgUrl iu = new ImgUrl();
            iu.setPath(path);
            iu.setUrl(url);
            return iu;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/add.do")
    public String add(GoodsInfo goodsInfo,Model model){
        String info = "操作失败！";
        try {
            goodsInfoService.addGoods(goodsInfo);
            info = "操作成功！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("info",info);
        return "goodsinfo/goodsinfo_add";
    }

    @Autowired
    public void setGoodsInfoService(GoodsInfoService goodsInfoService) {
        this.goodsInfoService = goodsInfoService;
    }
}
