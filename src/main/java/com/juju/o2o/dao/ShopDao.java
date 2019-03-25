package com.juju.o2o.dao;

import com.juju.o2o.entity.Shop;


public interface ShopDao {

    /*
    * 通过 shop id 查询店铺
    * */
    Shop queryByShopId (Long shopId);

    /*
    * 新增店铺
    * */
    int insertShop(Shop shop);

    /**
     *
     */
    int updateShop(Shop shop);
}
