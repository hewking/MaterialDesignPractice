package com.dlodlo.mdpractice.activity;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

import org.jsoup.Jsoup;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.dlodlo.widget.linkpreview.Regex.IMAGE_TAG_PATTERN;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/04/13 19:27
 * 修改人员：Robi
 * 修改时间：2017/04/13 19:27
 * 修改备注：
 * Version: 1.0.0
 */
public class HtmlFrom {


    public static void getPageAsyc(String url) {
        AsyncTask<String, Integer, String> task = new AsyncTask<String, Integer, String>() {

            @Override
            protected String doInBackground(String... params) {
                return getStaticPageByBytes(params[0]);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.e("getPageAsyc" ,s);
                regexMatch(s,IMAGE_TAG_PATTERN);
                regexMatch(s,"<title>(.*?)</title>");



            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }
        }.execute(url);
    }

    public static void regexMatch(String content , String pattern ) {
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            Log.e("regexmatch",matcher.group(0));
            Matcher m = Pattern.compile("<title>([\\s\\S]*)</title>").matcher(matcher.group(0));
            Matcher m2 = Pattern.compile("<img.*?\"([\\s\\S]*)\" alt.*?>").matcher(matcher.group(0));

            String attr = Jsoup.parse(matcher.group(0)).select("img").attr("src");
            String title = Jsoup.parse(matcher.group(0)).select("title").text();
            Log.e("regexmatch jsoup after",attr);
            Log.e("regexmatch jsoup title",title);

            while(m2.find()){
//                System.out.println(m.group(1));
                Log.e("regexmatch after",m2.group(1));

            }
        }
    }



    private static String getStaticPageByBytes(String surl){

        Log.i("getStaticPageByBytes", surl );

        HttpURLConnection connection = null;
        InputStream is = null;

        ByteArrayOutputStream fos = null;

        try {
            URL url = new URL(surl);
            connection = (HttpURLConnection)url.openConnection();

            int code = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == code) {
                connection.connect();
                is = connection.getInputStream();
                fos = new ByteArrayOutputStream();

                int i;
                while((i = is.read()) != -1){
                    fos.write(i);
                }

                is.close();
                fos.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return fos.toString();
    }

}
