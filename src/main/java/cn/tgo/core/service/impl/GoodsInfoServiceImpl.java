package cn.tgo.core.service.impl;

import cn.tgo.core.bean.GoodsInfo;
import cn.tgo.core.dao.GoodsInfoDao;
import cn.tgo.core.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("goodsInfoService")
@Transactional
public class GoodsInfoServiceImpl implements GoodsInfoService {
    private GoodsInfoDao goodsInfoDao;

    public void addGoods(GoodsInfo goodsInfo) {
        System.out.println("插入"+goodsInfoDao.add(goodsInfo)+"条记录");

    }

    @Transactional(readOnly = true)
    public List<Map> getList(GoodsInfo goodsInfo) {
        return goodsInfoDao.getGoodsList(goodsInfo);
    }
    @Transactional(readOnly = true)
    public Long getCount(GoodsInfo goodsInfo) {
        return goodsInfoDao.getCount(goodsInfo);
    }
    @Transactional(readOnly = true)
    public Map getGoodsInfo(GoodsInfo goodsInfo) {
        return goodsInfoDao.getGoodsInfo(goodsInfo);
    }

    public void updateGoods(GoodsInfo goodsInfo) {
        System.out.println("更新"+goodsInfoDao.update(goodsInfo)+"条记录");
    }


    @Autowired
    public void setGoodsInfoDao(GoodsInfoDao goodsInfoDao) {
        this.goodsInfoDao = goodsInfoDao;
    }
}
