package cn.tgo.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品管理的控制器
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {


    @RequestMapping("/loadadd.do")
    public String loadadd(){
        return "goodsinfo/goodsinfo_add";
    }
}
