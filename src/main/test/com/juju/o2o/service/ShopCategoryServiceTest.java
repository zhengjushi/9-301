package com.juju.o2o.service;

import com.juju.o2o.BaseTest;
import com.juju.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryServiceTest extends BaseTest {

    @Autowired
    private ShopCategoryService shopCategoryService;

    @Test
    public void shopCategoryServiceTest(){
        List<ShopCategory> getShopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
    }
}
