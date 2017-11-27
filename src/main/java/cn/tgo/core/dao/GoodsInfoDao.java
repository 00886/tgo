package cn.tgo.core.dao;

import cn.tgo.core.bean.GoodsInfo;
import cn.tgo.core.bean.UserInfo;

import java.util.List;
import java.util.Map;

public interface GoodsInfoDao {
    /**
     * 添加商品
     * @param goodsInfo
     * @return
     */
    public int add(GoodsInfo goodsInfo);

    /**
     * 更新商品
     * @param goodsInfo
     * @return
     */
    public int update(GoodsInfo goodsInfo);

    /**
     * 删除用户
     * @param goodsInfo
     * @return
     */
    public int delete(GoodsInfo goodsInfo);

    /**
     * 根据条件查询
     * @param goodsInfo
     * @return
     */
    public List<Map> getGoodsList(GoodsInfo goodsInfo);

    /**
     * 查询总记录数
     * @param goodsInfo
     * @return
     */
    public long getCount(GoodsInfo goodsInfo);

    /**
     * 根据条件查询用户
     * @param goodsInfo
     * @return
     */
    public Map getGoodsInfo(GoodsInfo goodsInfo);


}
