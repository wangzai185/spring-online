package com.xqtc.api.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

    public static void main(String[] args) throws IOException {
        HttpResponse httpResponse = postJson("http://127.0.0.1:8099/userTest/test", "{ \"userType\":1, \"phone\":18552456191, \"phoneCode\":\"123456\" }");
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("statusCode:" + statusCode);
        HttpEntity resEntity = httpResponse.getEntity();
        String s = EntityUtils.toString(resEntity, "utf-8");
        System.out.println("s:" + s);
    }


    public static HttpResponse postJson(String url, String param) {
        HttpPost httpPost = null;
        String result = null;
        HttpResponse response = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();//获取DefaultHttpClient请求
            httpPost = new HttpPost(url);
            if (param != null) {
                StringEntity se = new StringEntity(param, "utf-8");
                httpPost.setEntity(se); // post方法中，加入json数据
                httpPost.setHeader("Content-Type", "application/json");
            }

            response = client.execute(httpPost);

//            if (response != null) {
//                HttpEntity resEntity = response.getEntity();
//                if (resEntity != null) {
//                    result = EntityUtils.toString(resEntity, "utf-8");
//                }
//            }

        } catch (Exception ex) {

        }
        return response;
    }

    public static String doPost(String url, Map<String, String> map) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        String charset = "utf-8";
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
