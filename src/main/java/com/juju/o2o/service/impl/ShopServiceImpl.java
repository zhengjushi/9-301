package com.juju.o2o.service.impl;

import com.juju.o2o.dao.ShopDao;
import com.juju.o2o.dto.ShopExecution;
import com.juju.o2o.entity.Shop;
import com.juju.o2o.enums.ShopStateEnum;
import com.juju.o2o.exceptions.ShopOperationExcetion;
import com.juju.o2o.service.ShopService;
import com.juju.o2o.util.ImageUtil;
import com.juju.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.File;
import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        //空值判断
        if (shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            //给店铺信息赋初始值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0){
                throw new ShopOperationExcetion("店铺创建失败");
            }else {
                if (shopImgInputStream != null){
                    //存储图片
                    try {
                        addShopImg(shop, shopImgInputStream,fileName);
                    } catch (Exception e) {
                        throw new ShopOperationExcetion("addShopImg error:"+e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0){
                        throw new ShopOperationExcetion("更新图片地址失败");
                    }
                }
            }

        }catch (Exception e){
            throw new ShopOperationExcetion("addShop error:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }
    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {

        //获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
