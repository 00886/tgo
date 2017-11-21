package cn.tgo.core.service.impl;

import cn.tgo.core.bean.GoodsInfo;
import cn.tgo.core.dao.GoodsInfoDao;
import cn.tgo.core.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("goodsInfoService")
@Transactional
public class GoodsInfoServiceImpl implements GoodsInfoService {
    private GoodsInfoDao goodsInfoDao;

    public void addGoods(GoodsInfo goodsInfo) {
        System.out.println("插入"+goodsInfoDao.add(goodsInfo)+"条记录");

    }

    public GoodsInfoDao getGoodsInfoDao() {
        return goodsInfoDao;
    }

    @Autowired
    public void setGoodsInfoDao(GoodsInfoDao goodsInfoDao) {
        this.goodsInfoDao = goodsInfoDao;
    }
}
