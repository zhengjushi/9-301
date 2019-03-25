package com.juju.o2o.dao;

import com.juju.o2o.BaseTest;
import com.juju.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



public class ShopCategoryDaoTest extends BaseTest {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory(){
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
        ShopCategory testsCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(1L);
        shopCategoryList = shopCategoryDao.queryShopCategory(parentCategory);
        System.out.println(shopCategoryList);
        testsCategory.setParent(parentCategory);
        shopCategoryList = shopCategoryDao.queryShopCategory(testsCategory);
        System.out.println(shopCategoryList);

    }
}
