package com.juju.o2o.service;

import com.juju.o2o.BaseTest;
import com.juju.o2o.dto.ShopExecution;
import com.juju.o2o.entity.Area;
import com.juju.o2o.entity.PersonInfo;
import com.juju.o2o.entity.Shop;
import com.juju.o2o.entity.ShopCategory;
import com.juju.o2o.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(3L);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺3");
        shop.setPhone("tes3");
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setShopDesc("测试3");
        shop.setCreateTime(new Date());
        shop.setAdvice("审核中3");
        File shopImg = new File("D:\\微信图片_20180612212530.jpg");
        InputStream is = new FileInputStream(shopImg);
       ShopExecution se =  shopService.addShop(shop,is,shopImg.getName());
       assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}
