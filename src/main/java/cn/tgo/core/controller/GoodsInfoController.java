package cn.tgo.core.controller;

import cn.tgo.core.bean.GoodsInfo;
import cn.tgo.core.bean.ImgUrl;
import cn.tgo.core.service.GoodsInfoService;
import cn.tgo.util.BaseController;
import cn.tgo.util.Common;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 商品管理的控制器
 */
@Controller
@RequestMapping("/goods")
public class GoodsInfoController extends BaseController {


    private GoodsInfoService goodsInfoService;

    @RequestMapping("/loadadd.do")
    public String loadadd(){
        return "goodsinfo/goodsinfo_add";
    }

    @RequestMapping("/loadupdate.do")
    public String loadUpdate(GoodsInfo goodsInfo, Model model){
        Map goods = goodsInfoService.getGoodsInfo(goodsInfo);
        model.addAttribute("goods",goods);
        return "goodsinfo/goodsinfo_update";
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
            //System.out.println(format);

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

    @RequestMapping("/uploadfile.do")
    public void uploadfile(@RequestParam(required = false) MultipartFile upload, HttpServletResponse response, HttpServletRequest request) {
        try {
            // 图片名称生成策略
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String format = df.format(new Date());
            System.out.println(format);
            Random r = new Random();
            for (int i = 0; i < 3; i++) {
                format += r.nextInt(100);
            }
            // 保存数据库路径
            String path = "upload/" + format + ".jpg";
            // 另外一台服务器地址
            String url = Common.IMG_SERVER_URL + path;
            // 实例化jersey
            Client client = new Client();
            // 设置请求路径
            WebResource resource = client.resource(url);
            resource.put(String.class, upload.getBytes());
            //响应
            PrintWriter out = response.getWriter();
            //获取路径
            //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
            String callback = request.getParameter("CKEditorFuncNum");
            out.print("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+url+"') </script>");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/list.do")
    public String list(Model model, GoodsInfo goodsInfo, HttpServletRequest request){
        if(goodsInfo != null){
            initPage(request);
            //设置起始记录数
            goodsInfo.setStart(this.getPageNo());
            //每页显示记录数
            goodsInfo.setLength(getPageNumBig());
        }
        List<Map> list = goodsInfoService.getList(goodsInfo);

        model.addAttribute("list",list);
        //总记录数
        model.addAttribute("total", goodsInfoService.getCount(goodsInfo));

        return "goodsinfo/goodsinfo_list";
    }


    @RequestMapping("/add.do")
    public String add(GoodsInfo goodsInfo,Model model){
        String info = "操作失败！";
        try {
            if(goodsInfo != null){
                goodsInfo.setGoodsState(Common.GOODS_STATE_UP);
            }
            goodsInfoService.addGoods(goodsInfo);
            info = "操作成功！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("info",info);
        return "goodsinfo/goodsinfo_add";
    }

    @RequestMapping("/goodsinfo.do")
    public String show(GoodsInfo goodsInfo,Model model){
        Map goods = goodsInfoService.getGoodsInfo(goodsInfo);
        System.out.println(goods);
        model.addAttribute("goods",goods);
        return "goodsinfo/goodsinfo_show";
    }
    @RequestMapping("/update.do")
    public String update(GoodsInfo goodsInfo,Model model,HttpServletRequest request){
        String info = "操作失败！";
        try {
            System.out.println(goodsInfo.toString());
            goodsInfoService.updateGoods(goodsInfo);
            info = "操作成功！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("info",info);
        return list(model,goodsInfo,request);
    }

    @Autowired
    public void setGoodsInfoService(GoodsInfoService goodsInfoService) {
        this.goodsInfoService = goodsInfoService;
    }
}
