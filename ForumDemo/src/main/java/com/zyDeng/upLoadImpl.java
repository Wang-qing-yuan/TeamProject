package com.zyDeng;


public class upLoadImpl implements upLoad {
    @Override
    public boolean checkOutPicStyle(Picture picture) throws styleException {

        String style = picture.getStyle();
        if (style.equals("jpg")||style.equals("png")){
            return true;
        }else {
            throw new styleException("图片格式不正确，请上传jpg或者png的图片！！");
        }
    }

    @Override
    public boolean checkOutTheme(String theme) throws themeException {
        int length = theme.length();
        if (length <= 20) {
            return true;
        }else {
            throw new themeException("帖子标题长度不能超出20个字,发布失败！");
        }
    }

    @Override
    public boolean checkOutPicNum(int num) throws picNumException {
        if (num < 9) {
            return true;
        }else {
            throw new picNumException("帖子的图片最多9张");
        }
    }

}
