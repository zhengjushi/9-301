package com.juju.o2o.util;

public class PathUtil {
    //获取系统默认路径的分隔符
    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath(){
        //获取操作系统的类型
        String os = System.getProperty("os.name");
        String basePath ="";
        //判断
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/projectdev/image/";
        }else {
            basePath = "/home/juju/image";
        }
        basePath =  basePath.replace("/",seperator);
        return basePath;
    }

    public static String getShopImagePath(Long shopId){
        String imagePath = "upload\\item\\shop\\" + shopId +"\\";
        return imagePath.replace("\\",seperator);
    }


}
