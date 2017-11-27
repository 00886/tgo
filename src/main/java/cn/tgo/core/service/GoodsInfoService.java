package cn.tgo.core.service;

import cn.tgo.core.bean.GoodsInfo;
import cn.tgo.core.dao.GoodsInfoDao;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public interface GoodsInfoService {

    /**
     * 添加商品
     * @param goodsInfo
     */
    void addGoods(GoodsInfo goodsInfo);

    List<Map> getList(GoodsInfo goodsInfo);

    Long getCount(GoodsInfo goodsInfo);

    Map getGoodsInfo(GoodsInfo goodsInfo);

    void updateGoods(GoodsInfo goodsInfo);


}
