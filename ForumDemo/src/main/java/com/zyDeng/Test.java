package com.zyDeng;

import com.github.houbb.sensitive.word.bs.SensitiveWordBs;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        //变量区
        Scanner scan = new Scanner(System.in);
        Forum forum = new Forum();
        List<Posts> postsList = new ArrayList<>();
        Posts posts = new Posts();
        Set<Picture> pictureList = new TreeSet<>();
        Picture picture;
        String editContent = "";
        upLoad upLoad = new upLoadImpl();
        String in = "1";
        //进入论坛
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>欢迎来到内卷论坛！<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        while (!in.equals("3")) {
            System.out.println("请输入您要做的操作");
            System.out.println("1、查看论坛   2、发布帖子   3、退出论坛");
            //变量区
            in = scan.next();
            //进入论坛
            switch (in) {
                case "1":
                    Iterator<Posts> iterator = postsList.iterator();
                    if (postsList.size() == 0) {
                        System.out.println("该论坛还没有帖子呢！");
                    }
                    while (iterator.hasNext()) {
                        Posts postsView = iterator.next();
                        System.out.print("作者：");
                        System.out.println(postsView.getAuthor());
                        System.out.print("日期：");
                        System.out.println(postsView.getTime());
                        //如果帖子有内容就展示，没有就不展示
                        if (!"".equals(postsView.getContent())) {
                            System.out.print("标题：");
                            System.out.println(postsView.getTitle());
                            System.out.println("内容：");
                            showContent(postsView);
                        }
                        //如果有图片就展示，没有就不展示
                        if (postsView.getPicture().size() != 0) {
                            System.out.println("图片：");
                            showPicture(postsView.getPicture());
                        }
                        System.out.println("----------------------------------------------------");
                    }

                    break;
                case "2":
                    String editchooes = "";

                    edit:
                    while (!editchooes.equals("3")) {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>编辑<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println("请选择您接下来的操作：1、上传图片  2、编辑内容  3、取消发布   4、保存   5、发布");
                        System.out.println("草稿内容：");
                        if (posts.getTitle() != null) {
                            System.out.print("标题：");
                            System.out.println(posts.getTitle());
                        }
                        if (posts.getContent() != null) showContent(posts);
                        else System.out.println("内容：无");
                        if (pictureList.size() != 0) {
                            System.out.println("图片：");
                            showPicture(pictureList);
                        } else System.out.println("图片：无");
                        System.out.println("------------------------------------------------|");
                        editchooes = scan.next();
                        String contains;
                        switch (editchooes) {
                            case "1":
                                System.out.println("请输入上传图片的信息：");
                                try {
                                    String picName = scan.next();
                                    String picStyle = scan.next();
                                    int picSize = scan.nextInt();
                                    picture = new Picture(picName, picStyle, picSize);
                                    if (upLoad.checkOutPicStyle(picture)) {
                                        int num = pictureList.size();
                                        upLoad.checkOutPicNum(pictureList.size());

                                        if (containsPicture(pictureList, picture) ) {
                                            System.err.println("该照片已存在！");
                                        } else {
                                            pictureList.add(picture);
                                        }
                                    }
                                } catch (styleException e) {
                                    System.err.println(e.getMessage());
                                } catch (InputMismatchException e) {
                                    System.err.println("请输入正确的字符");
                                }catch (picNumException e) {
                                    System.err.println(e.getMessage());
                                } finally {
                                    break;
                                }
                            case "2":
                                try {
                                    System.out.println("请输入您的标题：");
                                    String title = scan.next();
                                    if (upLoad.checkOutTheme(title)) {
                                        System.out.println("请输入您要发布的内容：");
                                        editContent = scan.next();
                                        posts.setContent(editContent);
                                        posts.setTitle(title);
                                    }
                                } catch (themeException e) {
                                    System.err.println(e.getMessage());
                                } finally {
                                    break;
                                }
                            case "3":
                                System.out.println("是否保存？（N/Y）");
                                String isSave = scan.next();
                                if (isSave.equalsIgnoreCase("N")) {
                                    posts = new Posts();
                                    pictureList = new TreeSet<>();
                                    break;
                                }
                            case "4":
                                posts.setPicture(pictureList);
                                //将帖子内容的敏感字替换然后保存
                                contains = SensitiveWordBs.newInstance().replace(editContent);
                                posts.setContent(contains);
                                System.out.println("保存成功");
                                break edit;
                            case "5":
                                System.out.println("请输入您的名字：");
                                String name = scan.next();
                                posts.setAuthor(name);
                                posts.setTime(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()));
                                contains = SensitiveWordBs.newInstance().replace(editContent);
                                posts.setContent(contains);
                                //将图片保存
                                posts.setPicture(pictureList);
                                postsList.add(posts);
                                posts = new Posts();
                                pictureList = new TreeSet<>();
                                System.out.println("帖子发布成功");
                                break edit;
                            default:
                                System.out.println("选择有误！");
                        }
                    }
                    System.out.println();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("选择有误！");
            }
        }
        System.out.println("已经退出论坛！");


    }

    /**
     * 查看草稿里是否含有名字和格式相同的图片
     *
     * @param pictureList
     * @param picture
     * @return
     */
    public static boolean containsPicture(Set<Picture> pictureList, Picture picture) {
        Iterator<Picture> iterator = pictureList.iterator();
        boolean flag = false;
        while (iterator.hasNext()) {
            Picture p = iterator.next();
            if (p.getName().equals(picture.getName()) && p.getStyle().equals(picture.getStyle())) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 显示图片信息
     *
     * @param pictureList
     */
    public static void showPicture(Set<Picture> pictureList) {
        Iterator<Picture> iterator = pictureList.iterator();
        while (iterator.hasNext()) {
            Picture p = iterator.next();
            System.out.println(p.getName() + "." + p.getStyle() + " 大小 ：" + p.getSize() + "kb");
        }
    }

    /**
     * 显示帖子内容
     *
     * @param posts
     */
    public static void showContent(Posts posts) {
        String postsCache = posts.getContent();
        int length = postsCache.length();
        String str = "";
        for (int i = 0; i < length / 20 + 1; i++) {
            int index = length % 20;
            if (i == length / 20) {
                str = postsCache.substring(20 * i, 20 * i + index);
            } else {
                str = postsCache.substring(20 * i, 20 * (i + 1));
            }
            System.out.println(str);
        }
    }
}
