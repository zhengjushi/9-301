package com.juju.o2o.dao;

import com.juju.o2o.BaseTest;
import com.juju.o2o.entity.Area;
import com.juju.o2o.entity.PersonInfo;
import com.juju.o2o.entity.Shop;
import com.juju.o2o.entity.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryByShopId(){
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId : " + shop.getArea().getAreaId());
        System.out.println("areaName : " + shop.getArea().getAreaName());
        System.out.println("shopCategoryId : " + shop.getShopCategory().getShopCategoryId());
        System.out.println("shopCategoryName : " + shop.getShopCategory().getShopCategoryName());
    }

    @Test
    @Ignore
    public void testInsertShop(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(3L);
        shopCategory.setShopCategoryId(1L);
        System.out.println(".............................................."+shopCategory);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺");
        shop.setPhone("1234567890");
        shop.setShopImg("testImg");
        shop.setEnableStatus(1);
        shop.setShopDesc("测试");
        shop.setCreateTime(new Date());
        shop.setAdvice("审核中");
        System.out.println(shop);
        int effctedNum = shopDao.insertShop(shop);
        assertEquals(1,effctedNum);
    }

    @Test
    @Ignore
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("测试店铺");
        shop.setPhone("测试号码");
        shop.setShopImg("测试图片");
        shop.setLastEditTime(new Date());
        int effctedNum = shopDao.updateShop(shop);
        assertEquals(1,effctedNum);
    }
}
