package com.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/04/14 9:33
 * 修改人员：Robi
 * 修改时间：2017/04/14 9:33
 * 修改备注：
 * Version: 1.0.0
 */
public class RegualText {

    public static void main(String[] args) {

//        String url = "csfdsdls/50014997";
//        String regex = "((http|ftp|https):\\/\\/)?[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";
//
//        Pattern pattern = Pattern.compile(regex);
//        System.out.println(pattern.matcher(url).matches());

//        String str = "<p class='xxxx'> Content\n\r内容\t\n\n</p>";
//        Matcher m = Pattern.compile("<p.*?>([\\s\\S]*)</p>").matcher(str);
//        while(m.find()){
//            System.out.println(m.group(1));
//        }

        String str = "<img src=\"https://m.baidu.com/static/index/plus/plus_logo.png\"  alt=\"百度一下,你就知道\">";
        Matcher m2 = Pattern.compile("<img.*?\"([\\s\\S]*)\".*?>").matcher(str);
        while(m2.find()){
            System.out.println(m2.group(1));
        }

    }

}
