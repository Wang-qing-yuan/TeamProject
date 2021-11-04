package com.zyDeng;

public interface upLoad {
    /**
     * 检查图片的类型
     * @param picture
     * @return
     * @throws styleException
     */
    boolean checkOutPicStyle(Picture picture) throws styleException;

 /*  //**
     * 检查帖子的内容
     * @param posts
     * @return
     * @throws contentException
     *//*
    ResultTemplate checkOutContent(Posts posts) throws contentException;
*/
    /**
     * 检查帖子的标题
     * @param theme
     * @return
     * @throws themeException
     */
    boolean checkOutTheme(String theme) throws themeException;

    /**
     * 检查帖子图片的数量
     * @param num
     * @return
     * @throws themeException
     */
    boolean checkOutPicNum(int num) throws picNumException;
}
